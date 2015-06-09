package com.example.ettie.listviewdemo;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    private String[] countries = {"Albania", "Algeria", "Armenia", "Andora", "Angola", "Argentina", "Australia", "Bahrain",
            "Bangladesh", "Barbados", "Brazil", "China", "Denmark", "Egypt", "France", "Ghana", "Hong Kong", "India", "Italy",
            "United Kingdom", "United States", "United Arab Emirates"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked,countries);
        ListView listView = getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        setListAdapter(adapter);
    }

    public void showSelectedItems(View v) {
        ListView listView = getListView();
        String itemsSelected = "Selected Items: \n";
        for (int i = 0; i < listView.getCount(); i++) {
            if(listView.isItemChecked(i)) {
                itemsSelected += listView.getItemAtPosition(i) + "\n";
            }
        }
        Toast.makeText(this, itemsSelected, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(this, "Item clicked: " + countries[position], Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
