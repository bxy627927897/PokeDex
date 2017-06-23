package edison.pokemon_try;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by MSI on 2016/12/16.
 */
public class pokeinfo_activity extends AppCompatActivity {
    private pokemonDB dataBase;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_layout);

        final Button button1 = (Button) findViewById(R.id.pre);
        final Button button2 = (Button) findViewById(R.id.next);

        final Button button3 = (Button) findViewById(R.id.back);
        final ImageView photo = (ImageView) findViewById(R.id.pokemon_photo);
        final TextView chname = (TextView) findViewById(R.id.pokemon_chname);
        final TextView jpname = (TextView) findViewById(R.id.pokemon_jpname);
        final TextView enname = (TextView) findViewById(R.id.pokemon_enname);
        final ImageView attribute1 = (ImageView) findViewById(R.id.pokemon_attribute1);
        final ImageView attribute2 = (ImageView) findViewById(R.id.pokemon_attribute2);
        final TextView introduce = (TextView) findViewById(R.id.pokemon_introduce);
        final TextView number = (TextView) findViewById(R.id.pokemon_number);
        final TextView classes = (TextView) findViewById(R.id.pokemon_classes);
        final TextView characteristic1 = (TextView) findViewById(R.id.pokemon_characteristic1);
        final TextView characteristic2 = (TextView) findViewById(R.id.pokemon_characteristic2);
        final TextView height = (TextView) findViewById(R.id.pokemon_height);
        final TextView weight = (TextView) findViewById(R.id.pokemon_weight);
        final TextView egg1 = (TextView) findViewById(R.id.pokemon_egg1);
        final TextView egg2 = (TextView) findViewById(R.id.pokemon_egg2);
        final TextView probability = (TextView) findViewById(R.id.pokemon_probability);
        final TextView steps = (TextView) findViewById(R.id.pokemon_steps);
        final TextView hp = (TextView) findViewById(R.id.pokemon_hp);
        final TextView hpshow = (TextView) findViewById(R.id.pokemon_hp_show);
        final TextView wg = (TextView) findViewById(R.id.pokemon_wg);
        final TextView wgshow = (TextView) findViewById(R.id.pokemon_wg_show);
        final TextView wf = (TextView) findViewById(R.id.pokemon_wf);
        final TextView wfshow = (TextView) findViewById(R.id.pokemon_wf_show);
        final TextView tg = (TextView) findViewById(R.id.pokemon_tg);
        final TextView tgshow = (TextView) findViewById(R.id.pokemon_tg_show);
        final TextView tf = (TextView) findViewById(R.id.pokemon_tf);
        final TextView tfshow = (TextView) findViewById(R.id.pokemon_tf_show);
        final TextView sd = (TextView) findViewById(R.id.pokemon_sd);
        final TextView sdshow = (TextView) findViewById(R.id.pokemon_sd_show);
        final ImageView evolution = (ImageView) findViewById(R.id.pokemon_evolution);


        Intent intent = getIntent();
        String idstring = intent.getStringExtra("idExtra");
        int id = Integer.valueOf(idstring).intValue();
        dataBase = new pokemonDB(pokeinfo_activity.this);
        final pokemonlist pokeList = dataBase.getID(id);


        number.setText(pokeList.number);
        chname.setText(pokeList.chname);
        jpname.setText(pokeList.jpname);
        enname.setText(pokeList.enname);
        introduce.setText(pokeList.introduce);
        classes.setText(pokeList.classes);
        characteristic1.setText(pokeList.characteristic1);
        characteristic2.setText(pokeList.characteristic2);
        height.setText(pokeList.height);
        weight.setText(pokeList.weight);
        egg1.setText(pokeList.egg1);
        egg2.setText(pokeList.egg2);
        probability.setText(pokeList.probability);
        steps.setText(pokeList.steps);
        hp.setText(pokeList.hp);
        wg.setText(pokeList.wg);
        wf.setText(pokeList.wf);
        tg.setText(pokeList.tg);
        tf.setText(pokeList.tf);
        sd.setText(pokeList.sd);

        if (pokeList.attribute1.equals("bug")) {
            attribute1.setImageResource(R.drawable.attribute_bug);
        } else if (pokeList.attribute1.equals("dark")) {
            attribute1.setImageResource(R.drawable.attribute_dark);
        } else if (pokeList.attribute1.equals("dragon")) {
            attribute1.setImageResource(R.drawable.attribute_dragon);
        } else if (pokeList.attribute1.equals("electric")) {
            attribute1.setImageResource(R.drawable.attribute_electric);
        } else if (pokeList.attribute1.equals("fairy")) {
            attribute1.setImageResource(R.drawable.attribute_fairy);
        } else if (pokeList.attribute1.equals("fighting")) {
            attribute1.setImageResource(R.drawable.attribute_fighting);
        } else if (pokeList.attribute1.equals("fire")) {
            attribute1.setImageResource(R.drawable.attribute_fire);
        } else if (pokeList.attribute1.equals("flying")) {
            attribute1.setImageResource(R.drawable.attribute_flying);
        } else if (pokeList.attribute1.equals("ghost")) {
            attribute1.setImageResource(R.drawable.attribute_ghost);
        } else if (pokeList.attribute1.equals("grass")) {
            attribute1.setImageResource(R.drawable.attribute_grass);
        } else if (pokeList.attribute1.equals("ground")) {
            attribute1.setImageResource(R.drawable.attribute_ground);
        } else if (pokeList.attribute1.equals("ice")) {
            attribute1.setImageResource(R.drawable.attribute_ice);
        } else if (pokeList.attribute1.equals("normal")) {
            attribute1.setImageResource(R.drawable.attribute_normal);
        } else if (pokeList.attribute1.equals("poison")) {
            attribute1.setImageResource(R.drawable.attribute_poison);
        } else if (pokeList.attribute1.equals("psychic")) {
            attribute1.setImageResource(R.drawable.attribute_psychic);
        } else if (pokeList.attribute1.equals("rock")) {
            attribute1.setImageResource(R.drawable.attribute_rock);
        } else if (pokeList.attribute1.equals("steel")) {
            attribute1.setImageResource(R.drawable.attribute_steel);
        } else if (pokeList.attribute1.equals("water")) {
            attribute1.setImageResource(R.drawable.attribute_water);
        } else if (pokeList.attribute1.equals("zero")) {
            attribute1.setImageResource(R.drawable.attribute_zero);
        }

        if (pokeList.attribute2.equals("bug")) {
            attribute2.setImageResource(R.drawable.attribute_bug);
        } else if (pokeList.attribute2.equals("dark")) {
            attribute2.setImageResource(R.drawable.attribute_dark);
        } else if (pokeList.attribute2.equals("dragon")) {
            attribute2.setImageResource(R.drawable.attribute_dragon);
        } else if (pokeList.attribute2.equals("electric")) {
            attribute2.setImageResource(R.drawable.attribute_electric);
        } else if (pokeList.attribute2.equals("fairy")) {
            attribute2.setImageResource(R.drawable.attribute_fairy);
        } else if (pokeList.attribute2.equals("fighting")) {
            attribute2.setImageResource(R.drawable.attribute_fighting);
        } else if (pokeList.attribute2.equals("fire")) {
            attribute2.setImageResource(R.drawable.attribute_fire);
        } else if (pokeList.attribute2.equals("flying")) {
            attribute2.setImageResource(R.drawable.attribute_flying);
        } else if (pokeList.attribute2.equals("ghost")) {
            attribute2.setImageResource(R.drawable.attribute_ghost);
        } else if (pokeList.attribute2.equals("grass")) {
            attribute2.setImageResource(R.drawable.attribute_grass);
        } else if (pokeList.attribute2.equals("ground")) {
            attribute2.setImageResource(R.drawable.attribute_ground);
        } else if (pokeList.attribute2.equals("ice")) {
            attribute2.setImageResource(R.drawable.attribute_ice);
        } else if (pokeList.attribute2.equals("normal")) {
            attribute2.setImageResource(R.drawable.attribute_normal);
        } else if (pokeList.attribute2.equals("poison")) {
            attribute2.setImageResource(R.drawable.attribute_poison);
        } else if (pokeList.attribute2.equals("psychic")) {
            attribute2.setImageResource(R.drawable.attribute_psychic);
        } else if (pokeList.attribute2.equals("rock")) {
            attribute2.setImageResource(R.drawable.attribute_rock);
        } else if (pokeList.attribute2.equals("steel")) {
            attribute2.setImageResource(R.drawable.attribute_steel);
        } else if (pokeList.attribute2.equals("water")) {
            attribute2.setImageResource(R.drawable.attribute_water);
        } else if (pokeList.attribute2.equals("zero")) {
            attribute2.setImageResource(R.drawable.attribute_zero);
        }

        if (pokeList.photo.equals("001")) {
            photo.setImageResource(R.drawable.px_001);
        } else if (pokeList.photo.equals("002")) {
            photo.setImageResource(R.drawable.px_002);
        } else if (pokeList.photo.equals("003")) {
            photo.setImageResource(R.drawable.px_003);
        } else if (pokeList.photo.equals("004")) {
            photo.setImageResource(R.drawable.px_004);
        } else if (pokeList.photo.equals("005")) {
            photo.setImageResource(R.drawable.px_005);
        } else if (pokeList.photo.equals("006")) {
            photo.setImageResource(R.drawable.px_006);
        } else if (pokeList.photo.equals("007")) {
            photo.setImageResource(R.drawable.px_007);
        } else if (pokeList.photo.equals("008")) {
            photo.setImageResource(R.drawable.px_008);
        } else if (pokeList.photo.equals("009")) {
            photo.setImageResource(R.drawable.px_009);
        } else if (pokeList.photo.equals("010")) {
            photo.setImageResource(R.drawable.px_010);
        } else if (pokeList.photo.equals("011")) {
            photo.setImageResource(R.drawable.px_011);
        } else if (pokeList.photo.equals("012")) {
            photo.setImageResource(R.drawable.px_012);
        } else if (pokeList.photo.equals("013")) {
            photo.setImageResource(R.drawable.px_013);
        } else if (pokeList.photo.equals("014")) {
            photo.setImageResource(R.drawable.px_014);
        } else if (pokeList.photo.equals("015")) {
            photo.setImageResource(R.drawable.px_015);
        } else if (pokeList.photo.equals("016")) {
            photo.setImageResource(R.drawable.px_016);
        } else if (pokeList.photo.equals("017")) {
            photo.setImageResource(R.drawable.px_017);
        } else if (pokeList.photo.equals("018")) {
            photo.setImageResource(R.drawable.px_018);
        } else if (pokeList.photo.equals("019")) {
            photo.setImageResource(R.drawable.px_019);
        } else if (pokeList.photo.equals("020")) {
            photo.setImageResource(R.drawable.px_020);
        }

        if (pokeList.number.equals("001")) {
            evolution.setImageResource(R.drawable.jinhua_001);
        } else if (pokeList.number.equals("002")) {
            evolution.setImageResource(R.drawable.jinhua_001);
        } else if (pokeList.number.equals("003")) {
            evolution.setImageResource(R.drawable.jinhua_001);
        } else if (pokeList.number.equals("004")) {
            evolution.setImageResource(R.drawable.jinhua_004);
        } else if (pokeList.number.equals("005")) {
            evolution.setImageResource(R.drawable.jinhua_004);
        } else if (pokeList.number.equals("006")) {
            evolution.setImageResource(R.drawable.jinhua_004);
        } else if (pokeList.number.equals("007")) {
            evolution.setImageResource(R.drawable.jinhua_007);
        } else if (pokeList.number.equals("008")) {
            evolution.setImageResource(R.drawable.jinhua_007);
        } else if (pokeList.number.equals("009")) {
            evolution.setImageResource(R.drawable.jinhua_007);
        } else if (pokeList.number.equals("010")) {
            evolution.setImageResource(R.drawable.jinhua_010);
        } else if (pokeList.number.equals("011")) {
            evolution.setImageResource(R.drawable.jinhua_010);
        } else if (pokeList.number.equals("012")) {
            evolution.setImageResource(R.drawable.jinhua_010);
        } else if (pokeList.number.equals("013")) {
            evolution.setImageResource(R.drawable.jinhua_013);
        } else if (pokeList.number.equals("014")) {
            evolution.setImageResource(R.drawable.jinhua_013);
        } else if (pokeList.number.equals("015")) {
            evolution.setImageResource(R.drawable.jinhua_013);
        } else if (pokeList.number.equals("016")) {
            evolution.setImageResource(R.drawable.jinhua_016);
        } else if (pokeList.number.equals("017")) {
            evolution.setImageResource(R.drawable.jinhua_016);
        } else if (pokeList.number.equals("018")) {
            evolution.setImageResource(R.drawable.jinhua_016);
        } else if (pokeList.number.equals("019")) {
            evolution.setImageResource(R.drawable.jinhua_019);
        } else if (pokeList.number.equals("020")) {
            evolution.setImageResource(R.drawable.jinhua_019);
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pokeList.id == 1) {
                    Toast.makeText(pokeinfo_activity.this, "前面没有啦", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(pokeinfo_activity.this, pokeinfo_activity.class);
                    String stringid = String.valueOf(pokeList.id-1);
                    intent.putExtra("idExtra", stringid);
                    startActivity(intent);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pokeList.id == 30) {
                    Toast.makeText(pokeinfo_activity.this, "后面没有啦", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(pokeinfo_activity.this, pokeinfo_activity.class);
                    String stringid = String.valueOf(pokeList.id+1);
                    intent.putExtra("idExtra", stringid);
                    startActivity(intent);
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(pokeinfo_activity.this, pokelist_activity.class);
                    startActivity(intent);

            }
        });

    }
}
