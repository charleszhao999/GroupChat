package w2.jan29th.groupchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.content.res.Configuration.UI_MODE_NIGHT_MASK;

public class AddActivity extends AppCompatActivity {
    public Button button;
    public int[] headChoice = new int[1];
    EditText groupName;
    EditText creator;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        Toolbar add_toolbar = (Toolbar) findViewById(R.id.add_toolbar);
        setSupportActionBar(add_toolbar);
        if (!isDarkTheme(AddActivity.this)) {
            setDarkStatusIcon(true);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        groupName = (EditText) findViewById(R.id.GroupName);
        creator = (EditText) findViewById(R.id.Creator);
        ImageView pic1 = (ImageView) findViewById(R.id.image1);
        Button back = (Button) findViewById(android.R.id.home);

        pic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup.check(R.id.radioButton1);
            }
        });
        ImageView pic2 = (ImageView) findViewById(R.id.image2);
        pic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup.check(R.id.radioButton2);
            }
        });
        ImageView pic3 = (ImageView) findViewById(R.id.image3);
        pic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup.check(R.id.radioButton3);
            }
        });
        ImageView pic4 = (ImageView) findViewById(R.id.image4);
        pic4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup.check(R.id.radioButton4);
            }
        });
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (groupName.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please input a groupname!", Toast.LENGTH_SHORT).show();
                } else if (creator.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please input a creator!", Toast.LENGTH_SHORT).show();
                } else {
                    switch (v.getId()) {
                        case R.id.button:
                            String Groupname = groupName.getText().toString();
                            String Creator = creator.getText().toString();
                            switch (radioGroup.getCheckedRadioButtonId()) {
                                case R.id.radioButton1:
                                    headChoice[0] = R.drawable.head1;
                                    break;
                                case R.id.radioButton2:
                                    headChoice[0] = R.drawable.head2;
                                    break;
                                case R.id.radioButton3:
                                    headChoice[0] = R.drawable.head3;
                                    break;
                                case R.id.radioButton4:
                                    headChoice[0] = R.drawable.head4;
                                    break;
                            }
                            Intent intent = new Intent(AddActivity.this, MainActivity.class);
                            intent.putExtra("group_name", Groupname);
                            intent.putExtra("group_creator", Creator);
                            intent.putExtra("group_head", headChoice[0]);
                            setResult(RESULT_OK, intent);
                            finish();
                            break;
                        default:
                            break;
                    }
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        } else if (item.getItemId() == R.id.done) {
            if (groupName.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "Please input a groupname!", Toast.LENGTH_SHORT).show();
            } else if (creator.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "Please input a creator!", Toast.LENGTH_SHORT).show();
            } else {
                String Groupname = groupName.getText().toString();
                String Creator = creator.getText().toString();
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioButton1:
                        headChoice[0] = R.drawable.head1;
                        break;
                    case R.id.radioButton2:
                        headChoice[0] = R.drawable.head2;
                        break;
                    case R.id.radioButton3:
                        headChoice[0] = R.drawable.head3;
                        break;
                    case R.id.radioButton4:
                        headChoice[0] = R.drawable.head4;
                        break;
                }
                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                intent.putExtra("group_name", Groupname);
                intent.putExtra("group_creator", Creator);
                intent.putExtra("group_head", headChoice[0]);
                setResult(RESULT_OK, intent);
                finish();

            }
        }

        return super.onOptionsItemSelected(item);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    public void setDarkStatusIcon(boolean bDark) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            View decorView = getWindow().getDecorView();
            if(decorView != null){
                int vis = decorView.getSystemUiVisibility();
                if(bDark){
                    vis |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                } else{
                    vis &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                }
                decorView.setSystemUiVisibility(vis);
            }
        }
    }
    Boolean isDarkTheme( Context context) {
        int flag = context.getResources().getConfiguration().uiMode & UI_MODE_NIGHT_MASK;
        return flag == Configuration.UI_MODE_NIGHT_YES;
    }
}