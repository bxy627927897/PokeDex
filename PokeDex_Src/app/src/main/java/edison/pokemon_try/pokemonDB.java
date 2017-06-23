package edison.pokemon_try;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by MSI on 2016/12/16.
 */
public class pokemonDB extends SQLiteOpenHelper {

    private final static String DB_NAME = "Edison.db";
    private final static String TABLE_NAME = "Edison_table";


    public pokemonDB(Context context) {
        super(context, DB_NAME, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE =  "CREATE TABLE if not exists "
                + TABLE_NAME
                +"(" + pokemonlist.KEY_ID + " INTEGER PRIMARY KEY ,"
                + "number text, "
                + "photo text, "
                + "pixelphoto text, "
                + "chname text, "
                + "jpname text, "
                + "enname text, "
                + "attribute1 text, "
                + "attribute2 text, "
                + "introduce text, "
                + "classes text, "
                + "characteristic1 text, "
                + "characteristic2 text, "
                + "height text, "
                + "weight text, "
                + "egg1 text, "
                + "egg2 text, "
                + "probability text, "
                + "steps text, "
                + "hp text, "
                + "hpshow text, "
                + "wg text, "
                + "wgshow text, "
                + "wf text, "
                + "wfshow text, "
                + "tg text, "
                + "tgshow text, "
                + "tf text, "
                + "tfshow text, "
                + "sd text, "
                + "sdshow text)";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
    }


    public int insert(pokemonlist birthList) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        /* 将新增的值放入ContentValues */
        cv.put(pokemonlist.KEY_ID, birthList.id);
        cv.put(pokemonlist.KEY_NUMBER, birthList.number);
        cv.put(pokemonlist.KEY_PHOTO, birthList.photo);
        cv.put(pokemonlist.KEY_PIXELPHOTO, birthList.pixelphoto);
        cv.put(pokemonlist.KEY_CHNAME, birthList.chname);
        cv.put(pokemonlist.KEY_JPNAME, birthList.jpname);
        cv.put(pokemonlist.KEY_ENNAME, birthList.enname);
        cv.put(pokemonlist.KEY_ATTRIBUTE1, birthList.attribute1);
        cv.put(pokemonlist.KEY_ATTRIBUTE2, birthList.attribute2);
        cv.put(pokemonlist.KEY_INTRODUCE, birthList.introduce);
        cv.put(pokemonlist.KEY_CLASSES, birthList.classes);
        cv.put(pokemonlist.KEY_CHARACTERISTIC1, birthList.characteristic1);
        cv.put(pokemonlist.KEY_CHARACTERISTIC2, birthList.characteristic2);
        cv.put(pokemonlist.KEY_HEIGHT, birthList.height);
        cv.put(pokemonlist.KEY_WEIGHT, birthList.weight);
        cv.put(pokemonlist.KEY_EGG1, birthList.egg1);
        cv.put(pokemonlist.KEY_EGG2, birthList.egg2);
        cv.put(pokemonlist.KEY_PROBABILITY, birthList.probability);
        cv.put(pokemonlist.KEY_STEPS, birthList.steps);
        cv.put(pokemonlist.KEY_HP, birthList.hp);
        cv.put(pokemonlist.KEY_HPSHOW, birthList.hpshow);
        cv.put(pokemonlist.KEY_WG, birthList.wg);
        cv.put(pokemonlist.KEY_WGSHOW, birthList.wgshow);
        cv.put(pokemonlist.KEY_WF, birthList.wf);
        cv.put(pokemonlist.KEY_WFSHOW, birthList.wfshow);
        cv.put(pokemonlist.KEY_TG, birthList.tg);
        cv.put(pokemonlist.KEY_TGSHOW, birthList.tgshow);
        cv.put(pokemonlist.KEY_TF, birthList.tf);
        cv.put(pokemonlist.KEY_TFSHOW, birthList.tfshow);
        cv.put(pokemonlist.KEY_SD, birthList.sd);
        cv.put(pokemonlist.KEY_SDSHOW, birthList.sdshow);
        long id = db.insert(pokemonlist.TABLE_NAME, null, cv);
        db.close();
        return (int)id;
    }

    public ArrayList<HashMap<String, Object>> getList() {
        SQLiteDatabase db = getReadableDatabase();
        String select = "SELECT "
                + pokemonlist.KEY_NUMBER + ","
                + pokemonlist.KEY_PIXELPHOTO + ","
                + pokemonlist.KEY_CHNAME + ","
                + pokemonlist.KEY_ID + ","
                + pokemonlist.KEY_ATTRIBUTE1 + ","
                + pokemonlist.KEY_ATTRIBUTE2 +
                " FROM " + pokemonlist.TABLE_NAME;
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        Cursor cursor = db.rawQuery(select, null);
        final int[] imagespic={R.drawable.pixel001,R.drawable.pixel002,R.drawable.pixel003,R.drawable.pixel004,R.drawable.pixel005,R.drawable.pixel006,
                R.drawable.pixel007,R.drawable.pixel008,R.drawable.pixel009,R.drawable.pixel010,R.drawable.pixel011,R.drawable.pixel012,R.drawable.pixel013,R.drawable.pixel014,
                R.drawable.pixel015,R.drawable.pixel016,R.drawable.pixel017,R.drawable.pixel018,R.drawable.pixel019,R.drawable.pixel020};
        final int[] imagespic2={R.drawable.attribute_bug,R.drawable.attribute_dark,R.drawable.attribute_dragon,R.drawable.attribute_electric,
                R.drawable.attribute_fairy,R.drawable.attribute_fighting,
                R.drawable.attribute_fire,R.drawable.attribute_flying,R.drawable.attribute_ghost,R.drawable.attribute_grass,R.drawable.attribute_ground,
                R.drawable.attribute_ice,R.drawable.attribute_normal,R.drawable.attribute_poison,R.drawable.attribute_psychic,
                R.drawable.attribute_rock,R.drawable.attribute_steel,R.drawable.attribute_water,R.drawable.attribute_zero};
        final int[] imagespic3={R.drawable.attribute_bug,R.drawable.attribute_dark,R.drawable.attribute_dragon,R.drawable.attribute_electric,
                R.drawable.attribute_fairy,R.drawable.attribute_fighting,
                R.drawable.attribute_fire,R.drawable.attribute_flying,R.drawable.attribute_ghost,R.drawable.attribute_grass,R.drawable.attribute_ground,
                R.drawable.attribute_ice,R.drawable.attribute_normal,R.drawable.attribute_poison,R.drawable.attribute_psychic,
                R.drawable.attribute_rock,R.drawable.attribute_steel,R.drawable.attribute_water,R.drawable.attribute_zero};
        if(cursor.moveToFirst()){  // 对数据库进行遍历
            do{
                HashMap<String,Object> temp=new HashMap<String,Object>();
                temp.put("id", cursor.getInt(cursor.getColumnIndex(pokemonlist.KEY_ID)));
                temp.put("number",cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_NUMBER)));
                temp.put("chname",cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_CHNAME)));
                temp.put("attribute1",cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE1)));
                temp.put("attribute2",cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE2)));
                temp.put("fpic", imagespic[cursor.getInt(cursor.getColumnIndex(pokemonlist.KEY_ID))-1]);

                if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE1)).equals("bug")) {
                    temp.put("attributepic1", imagespic2[0]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE1)).equals("dark")) {
                    temp.put("attributepic1", imagespic2[1]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE1)).equals("dragon")) {
                    temp.put("attributepic1", imagespic2[2]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE1)).equals("electric")) {
                    temp.put("attributepic1", imagespic2[3]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE1)).equals("fairy")) {
                    temp.put("attributepic1", imagespic2[4]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE1)).equals("fighting")) {
                    temp.put("attributepic1", imagespic2[5]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE1)).equals("fire")) {
                    temp.put("attributepic1", imagespic2[6]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE1)).equals("flying")) {
                    temp.put("attributepic1", imagespic2[7]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE1)).equals("ghost")) {
                    temp.put("attributepic1", imagespic2[8]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE1)).equals("grass")) {
                    temp.put("attributepic1", imagespic2[9]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE1)).equals("ground")) {
                    temp.put("attributepic1", imagespic2[10]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE1)).equals("ice")) {
                    temp.put("attributepic1", imagespic2[11]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE1)).equals("normal")) {
                    temp.put("attributepic1", imagespic2[12]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE1)).equals("poison")) {
                    temp.put("attributepic1", imagespic2[13]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE1)).equals("psychic")) {
                    temp.put("attributepic1", imagespic2[14]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE1)).equals("rock")) {
                    temp.put("attributepic1", imagespic2[15]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE1)).equals("steel")) {
                    temp.put("attributepic1", imagespic2[16]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE1)).equals("water")) {
                    temp.put("attributepic1", imagespic2[17]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE1)).equals("zero")) {
                    temp.put("attributepic1", imagespic2[18]);
                }

                if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE2)).equals("bug")) {
                    temp.put("attributepic2", imagespic3[0]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE2)).equals("dark")) {
                    temp.put("attributepic2", imagespic3[1]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE2)).equals("dragon")) {
                    temp.put("attributepic2", imagespic3[2]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE2)).equals("electric")) {
                    temp.put("attributepic2", imagespic3[3]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE2)).equals("fairy")) {
                    temp.put("attributepic2", imagespic3[4]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE2)).equals("fighting")) {
                    temp.put("attributepic2", imagespic3[5]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE2)).equals("fire")) {
                    temp.put("attributepic2", imagespic3[6]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE2)).equals("flying")) {
                    temp.put("attributepic2", imagespic3[7]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE2)).equals("ghost")) {
                    temp.put("attributepic2", imagespic3[8]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE2)).equals("grass")) {
                    temp.put("attributepic2", imagespic3[9]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE2)).equals("ground")) {
                    temp.put("attributepic2", imagespic3[10]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE2)).equals("ice")) {
                    temp.put("attributepic2", imagespic3[11]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE2)).equals("normal")) {
                    temp.put("attributepic2", imagespic3[12]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE2)).equals("poison")) {
                    temp.put("attributepic2", imagespic3[13]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE2)).equals("psychic")) {
                    temp.put("attributepic2", imagespic3[14]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE2)).equals("rock")) {
                    temp.put("attributepic2", imagespic3[15]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE2)).equals("steel")) {
                    temp.put("attributepic2", imagespic3[16]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE2)).equals("water")) {
                    temp.put("attributepic2", imagespic3[17]);
                } else if (cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE2)).equals("zero")) {
                    temp.put("attributepic2", imagespic3[18]);
                }


                list.add(temp);
            }while(cursor.moveToNext());  //如果能够继续
        }
        cursor.close();
        db.close();
        return list;
    }

    public pokemonlist getID(int id) {
        SQLiteDatabase db = getReadableDatabase();
        String select = "SELECT " + pokemonlist.KEY_ID + ","
                + pokemonlist.KEY_NUMBER + ","
                + pokemonlist.KEY_PHOTO + ","
                + pokemonlist.KEY_PIXELPHOTO + ","
                + pokemonlist.KEY_CHNAME + ","
                + pokemonlist.KEY_JPNAME + ","
                + pokemonlist.KEY_ENNAME + ","
                + pokemonlist.KEY_ATTRIBUTE1 + ","
                + pokemonlist.KEY_ATTRIBUTE2 + ","
                + pokemonlist.KEY_INTRODUCE + ","
                + pokemonlist.KEY_CLASSES + ","
                + pokemonlist.KEY_CHARACTERISTIC1 + ","
                + pokemonlist.KEY_CHARACTERISTIC2 + ","
                + pokemonlist.KEY_HEIGHT + ","
                + pokemonlist.KEY_WEIGHT + ","
                + pokemonlist.KEY_EGG1 + ","
                + pokemonlist.KEY_EGG2 + ","
                + pokemonlist.KEY_PROBABILITY + ","
                + pokemonlist.KEY_STEPS + ","
                + pokemonlist.KEY_HP + ","
                + pokemonlist.KEY_HPSHOW + ","
                + pokemonlist.KEY_WG + ","
                + pokemonlist.KEY_WGSHOW + ","
                + pokemonlist.KEY_WF + ","
                + pokemonlist.KEY_WFSHOW + ","
                + pokemonlist.KEY_TG + ","
                + pokemonlist.KEY_TGSHOW + ","
                + pokemonlist.KEY_TF + ","
                + pokemonlist.KEY_TFSHOW + ","
                + pokemonlist.KEY_SD + ","
                + pokemonlist.KEY_SDSHOW + " FROM " + pokemonlist.TABLE_NAME + " WHERE " + pokemonlist.KEY_ID + "=?";

        pokemonlist pokeList = new pokemonlist();
        Cursor cursor = db.rawQuery(select, new String[]{String.valueOf(id)});
        if (cursor.moveToFirst()) {
            do {
                pokeList.id = cursor.getInt(cursor.getColumnIndex(pokemonlist.KEY_ID));
                pokeList.number = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_NUMBER));
                pokeList.photo = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_PHOTO));
                pokeList.pixelphoto = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_PIXELPHOTO));
                pokeList.chname = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_CHNAME));
                pokeList.jpname = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_JPNAME));
                pokeList.enname = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ENNAME));
                pokeList.attribute1 = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE1));
                pokeList.attribute2 = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_ATTRIBUTE2));
                pokeList.introduce = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_INTRODUCE));
                pokeList.classes = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_CLASSES));
                pokeList.characteristic1 = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_CHARACTERISTIC1));
                pokeList.characteristic2 = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_CHARACTERISTIC2));
                pokeList.height = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_HEIGHT));
                pokeList.weight = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_WEIGHT));
                pokeList.egg1 = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_EGG1));
                pokeList.egg2 = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_EGG2));
                pokeList.probability = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_PROBABILITY));
                pokeList.steps = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_STEPS));
                pokeList.hp = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_HP));
                pokeList.hpshow = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_HPSHOW));
                pokeList.wg = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_WG));
                pokeList.wgshow = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_WGSHOW));
                pokeList.wf = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_WF));
                pokeList.wfshow = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_WFSHOW));
                pokeList.tg = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_TG));
                pokeList.tgshow = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_TGSHOW));
                pokeList.tf = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_TF));
                pokeList.tfshow = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_TFSHOW));
                pokeList.sd = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_SD));
                pokeList.sdshow = cursor.getString(cursor.getColumnIndex(pokemonlist.KEY_SDSHOW));
            }while (cursor.moveToNext());  //如果能够继续
        }
        cursor.close();
        db.close();
        return pokeList;
    }

}