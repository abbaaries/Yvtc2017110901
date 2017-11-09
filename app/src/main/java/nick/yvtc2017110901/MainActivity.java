package nick.yvtc2017110901;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> mylist = new ArrayList<>();
    ListView lv;
    String names[] = {"Bob", "John", "Mary", "Jane", "Peter", "Amy"};
    MyAdapter adapter;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView)findViewById(R.id.listview);

        adapter = new MyAdapter(MainActivity.this,names);
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("show");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<names.length;i++){
            if (adapter.check[i])
            sb.append(names[i]+",");
        }
        Toast.makeText(MainActivity.this,sb,Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
