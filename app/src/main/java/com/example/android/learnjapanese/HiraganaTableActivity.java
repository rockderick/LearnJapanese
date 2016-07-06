package com.example.android.learnjapanese;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.learnjapanese.logic.Hiragana;

public class HiraganaTableActivity extends AppCompatActivity {

    Button hiraganaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hiragana_table_layout);
    }


    public void showQuickReference(View v){
        //Button hiraganaButton = findViewById(R.id.)
        Hiragana hiraganaSymbol= new Hiragana("あ","A","Anillo",R.raw.hiragana1, R.raw.a);;

        switch (v.getId()){
            case R.id.hiragana_A:
                hiraganaSymbol = new Hiragana("あ","A","Anillo",R.raw.hiragana1, R.raw.a);
                break;
            case R.id.hiragana_I:
                hiraganaSymbol = new Hiragana("い","I","Isla",R.raw.hiragana2, R.raw.i);
                break;
            case R.id.hiragana_U:
                hiraganaSymbol = new Hiragana("う","U","Uña",R.raw.hiragana3,R.raw.u);
                break;
            case R.id.hiragana_E:
                hiraganaSymbol = new Hiragana("え","E","Elote",R.raw.hiragana4,R.raw.e);
                break;
            case R.id.hiragana_O:
                hiraganaSymbol = new Hiragana("お","O","Ola",R.raw.hiragana5,R.raw.o);
                break;

            case R.id.hiragana_KA:
                hiraganaSymbol = new Hiragana("か","KA","CAballo",R.raw.hiragana6,R.raw.ka);
                break;
            case R.id.hiragana_KI:
                hiraganaSymbol = new Hiragana("き","KI","QUIquiriquí",R.raw.hiragana7,R.raw.ki);
                break;
            case R.id.hiragana_KU:
                hiraganaSymbol = new Hiragana("く","KU","CUervo",R.raw.hiragana8,R.raw.ku);
                break;
            case R.id.hiragana_KE:
                hiraganaSymbol = new Hiragana("け","KE","QUEso",R.raw.hiragana9,R.raw.ke);
                break;
            case R.id.hiragana_KO:
                hiraganaSymbol = new Hiragana("こ","KO","KOala",R.raw.hiragana10,R.raw.ko);
                break;

            case R.id.hiragana_SA:
                hiraganaSymbol = new Hiragana("さ","SA","ZApato",R.raw.hiragana11,R.raw.sa);
                break;
            case R.id.hiragana_SHI:
                hiraganaSymbol = new Hiragana("し","SHI","SHhh",R.raw.hiragana12,R.raw.shi);
                break;
            case R.id.hiragana_SU:
                hiraganaSymbol = new Hiragana("す","SU","SUshi",R.raw.hiragana13,R.raw.su);
                break;
            case R.id.hiragana_SE:
                hiraganaSymbol = new Hiragana("せ","SE","SEcretaria",R.raw.hiragana14,R.raw.se);
                break;
            case R.id.hiragana_SO:
                hiraganaSymbol = new Hiragana("そ","SO","ZOpilote",R.raw.hiragana15,R.raw.so);
                break;

            case R.id.hiragana_TA:
                hiraganaSymbol = new Hiragana("た","TA","TAcos",R.raw.hiragana16,R.raw.ta);
                break;
            case R.id.hiragana_CHI:
                hiraganaSymbol = new Hiragana("ち","CHI","CHIle",R.raw.hiragana17,R.raw.chi);
                break;
            case R.id.hiragana_TSU:
                hiraganaSymbol = new Hiragana("つ","TSU","TSUnami",R.raw.hiragana18,R.raw.tsu);
                break;
            case R.id.hiragana_TE:
                hiraganaSymbol = new Hiragana("て","TE","TElaraña",R.raw.hiragana19,R.raw.te);
                break;
            case R.id.hiragana_TO:
                hiraganaSymbol = new Hiragana("と","TO","TObillo",R.raw.hiragana20,R.raw.to);
                break;

            case R.id.hiragana_NA:
                hiraganaSymbol = new Hiragana("な","NA","NAriz",R.raw.hiragana21,R.raw.na);
                break;
            case R.id.hiragana_NI:
                hiraganaSymbol = new Hiragana("に","NI","NIdo",R.raw.hiragana22,R.raw.ni);
                break;
            case R.id.hiragana_NU:
                hiraganaSymbol = new Hiragana("ぬ","NU","NUdo",R.raw.hiragana23,R.raw.nu);
                break;
            case R.id.hiragana_NE:
                hiraganaSymbol = new Hiragana("ね","NE","NEptuno",R.raw.hiragana24,R.raw.ne);
                break;
            case R.id.hiragana_NO:
                hiraganaSymbol = new Hiragana("の","NO","NOpal",R.raw.hiragana25,R.raw.no);
                break;

            case R.id.hiragana_HA:
                hiraganaSymbol = new Hiragana("は","HA","JAmon",R.raw.hiragana26,R.raw.ha);
                break;
            case R.id.hiragana_HI:
                hiraganaSymbol = new Hiragana("に","HI","JIrafa",R.raw.hiragana27,R.raw.hi);
                break;
            case R.id.hiragana_FU:
                hiraganaSymbol = new Hiragana("ふ","FU","FUente",R.raw.hiragana28,R.raw.fu);
                break;
            case R.id.hiragana_HE:
                hiraganaSymbol = new Hiragana("へ","HE","JEringa",R.raw.hiragana29,R.raw.he);
                break;
            case R.id.hiragana_HO:
                hiraganaSymbol = new Hiragana("ほ","HO","JOrobado",R.raw.hiragana30,R.raw.ho);
                break;

            case R.id.hiragana_MA:
                hiraganaSymbol = new Hiragana("ま","MA","MAriachi",R.raw.hiragana31,R.raw.ma);
                break;
            case R.id.hiragana_MI:
                hiraganaSymbol = new Hiragana("み","MI","MIcrofono",R.raw.hiragana32,R.raw.mi);
                break;
            case R.id.hiragana_MU:
                hiraganaSymbol = new Hiragana("む","MU","MUrcielago",R.raw.hiragana33,R.raw.mu);
                break;
            case R.id.hiragana_ME:
                hiraganaSymbol = new Hiragana("め","ME","MEsa",R.raw.hiragana34,R.raw.me);
                break;
            case R.id.hiragana_MO:
                hiraganaSymbol = new Hiragana("も","MO","MOno",R.raw.hiragana35,R.raw.mo);
                break;

            case R.id.hiragana_YA:
                hiraganaSymbol = new Hiragana("や","YA","YA",R.raw.hiragana36,R.raw.ya);
                break;
            case R.id.hiragana_YU:
                hiraganaSymbol = new Hiragana("ゆ","YU","YUnque",R.raw.hiragana37,R.raw.yu);
                break;
            case R.id.hiragana_YO:
                hiraganaSymbol = new Hiragana("よ","Y0","YOga",R.raw.hiragana38,R.raw.yo);
                break;

            case R.id.hiragana_RA:
                hiraganaSymbol = new Hiragana("ら","RA","coRAzón",R.raw.hiragana39,R.raw.ra);
                break;
            case R.id.hiragana_RI:
                hiraganaSymbol = new Hiragana("り","RI","maRImba",R.raw.hiragana40,R.raw.ri);
                break;
            case R.id.hiragana_RU:
                hiraganaSymbol = new Hiragana("る","RU","oRUga",R.raw.hiragana41,R.raw.ru);
                break;
            case R.id.hiragana_RE:
                hiraganaSymbol = new Hiragana("れ","RE","siREna",R.raw.hiragana42,R.raw.re);
                break;
            case R.id.hiragana_RO:
                hiraganaSymbol = new Hiragana("ろ","RO","loRO",R.raw.hiragana43,R.raw.ro);
                break;


           case R.id.hiragana_WA:
               hiraganaSymbol = new Hiragana("わ","WA","HUArache",R.raw.hiragana44,R.raw.wa);
               break;
           case R.id.hiragana_WO:
               hiraganaSymbol = new Hiragana("を","WO","hOyo",R.raw.hiragana45,R.raw.wo);
               break;

           case R.id.hiragana_N:
               hiraganaSymbol = new Hiragana("ん","n","baNdera",R.raw.hiragana46,R.raw.n);
               break;





        }

        hiraganaButton = (Button) findViewById(v.getId());
        Bundle bundle = new Bundle();
        bundle.putCharSequence("HIRAGANA_READING", hiraganaSymbol.getReading());
        bundle.putInt("HIRAGANA_IMAGE", hiraganaSymbol.getImage());
        //bundle.put();
        Intent intent= new Intent(this, HiraganaActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
