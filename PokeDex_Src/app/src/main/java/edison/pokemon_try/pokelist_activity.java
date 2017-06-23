package edison.pokemon_try;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by MSI on 2016/12/15.
 */
public class pokelist_activity extends AppCompatActivity {
    private pokemonDB pokeDB;
    private pokemonlist pokeList;
    private ArrayList<HashMap<String, Object>> listmap ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemonlist_layout);

        final ListView ListofPokemon = (ListView) findViewById(R.id.pokemon_list);
        listmap = new pokemonDB(pokelist_activity.this).getList();


        ListofPokemon.setAdapter(new SimpleAdapter(pokelist_activity.this, listmap, R.layout.pokemon_item,
                new String[]{"fpic", "number", "chname", "attributepic1","attributepic2"},
                new int[]{R.id.list1_pic, R.id.list1_num, R.id.list1_name, R.id.list1_attribute1, R.id.list1_attribute2}));

        final int[] imagespic={R.drawable.px_001,R.drawable.px_002,R.drawable.px_003,R.drawable.px_004,R.drawable.px_005,R.drawable.px_006,
                R.drawable.px_007,R.drawable.px_008,R.drawable.px_009,R.drawable.px_010,R.drawable.px_011,R.drawable.px_012,R.drawable.px_013,R.drawable.px_014,
                R.drawable.px_015,R.drawable.px_016,R.drawable.px_017,R.drawable.px_018,R.drawable.px_019,R.drawable.px_020};

        final String[] pokemonname = new String[] {"妙蛙种子", "妙蛙草", "妙蛙花", "小火龙", "火恐龙", "喷火龙", "杰尼龟", "卡咪龟", "水箭龟",
                "绿毛虫", "铁甲蛹", "巴大蝴", "独角虫", "铁壳蛹", "大针蜂",
                "波波","比比鸟","大比鸟","小拉达","拉达"};

        ListofPokemon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(pokelist_activity.this, pokeinfo_activity.class);
                String stringid = String.valueOf(i+1);
                intent.putExtra("idExtra", stringid);
                startActivity(intent);
                Intent intent2 = new Intent("android.intent.action.staticreceiver");
                intent2.putExtra("fpic", imagespic[i]);
                intent2.putExtra("name", pokemonname[i]);
                sendBroadcast(intent2);
            }
        });

    }
}
