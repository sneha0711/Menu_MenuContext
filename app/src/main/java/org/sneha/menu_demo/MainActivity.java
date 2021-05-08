package org.sneha.menu_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int MENU_NEW = 1, MENU_SETTING = 2, MENU_HELP = 3;
    public static final int MENU_PHONE_SETTINGS = 10, MENU_SYS_SETTINGS = 11;

    private CheckBox mChkSettings;
    private TextView mTxtInfo;
    private EditText mEdtInfo;

    private String mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        setContentView(R.layout.activity_main);

        mChkSettings = findViewById(R.id.chkSettings);
        mTxtInfo = findViewById(R.id.txtInfo);
        mEdtInfo = findViewById(R.id.edtInfo);

        registerForContextMenu(mTxtInfo);
        registerForContextMenu(mEdtInfo);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuItem menuItem;
        menuItem = menu.add(0,MENU_NEW,0,R.string.menu_new);
        menuItem.setAlphabeticShortcut('N');
        menuItem.setNumericShortcut('9');
        menuItem.setIcon(android.R.drawable.ic_menu_add);
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        menuItem = menu.add(0,MENU_SETTING,0,R.string.menu_setting);
        menuItem.setCheckable(true);
        menuItem.setChecked(true);

        menu.add(0, MENU_HELP, 0, R.string.menu_help);

        return  true;


    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        mt("onPrepareOptionsMenu");

        menu.findItem(R.id.menuSettings);
       // menu.findItem(R.id.menu_setting).setEnabled(mChkSettings.isChecked());
//        menu.findItem(R.id.).setEnabled(mChkSettings.isChecked());

        //menu.findItem(MENU_SETTINGS).setEnabled(mChkSettings.isChecked());


        /*MenuItem menuItem = menu.findItem(MENU_SETTING);
        menuItem.setEnabled(mChkSettings.isChecked());
        */

       /* if(mChkSettings.isChecked()) {
            menuItem.setEnabled(true);
        }
        else {
            menuItem.setEnabled(false);
        }
*/
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

//        switch (item.getItemId())
//        {
//            case MENU_NEW:
//                mt("New");
//                break;
//
//            case  MENU_SETTING:
//                mt("Settings");
//                break;
//            case MENU_HELP:
//                mt("Help");
//                break;
//            case MENU_PHONE_SETTINGS:
//                break;
//
//
//
//        }
//        return  true;

        switch (item.getItemId()) {
            case R.id.menuNew:;
                mt("New");
                break;
            case R.id.menuSettings:
                mt("Settings");
                break;
            case R.id.menuHelp:
                mt("Help");
                break;
            case R.id.menuPhoneSettings:
                mt("Phone Settings");
                break;
            case R.id.menuSysSettings:
                mt("System Settings");
                break;
        }
        return  true;
    }
    private void mt(String text) {
        Log.e("tag", text);
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}