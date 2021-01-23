package w2.jan29th.groupchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent=getIntent();
        String groupName=intent.getStringExtra("group_name");
        String creator=intent.getStringExtra("creator");
        int head=intent.getIntExtra("head",1);
        TextView groupname=(TextView)findViewById(R.id.GroupName);
        TextView groupcreator=(TextView)findViewById(R.id.Creator);
        ImageView  grouphead=(ImageView)findViewById(R.id.head);
        groupname.setText(groupName);
        groupcreator.setText(creator);
        grouphead.setImageResource(head);

    }
}