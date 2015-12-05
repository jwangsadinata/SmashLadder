package hu.ait.android.smashladder;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

import hu.ait.android.smashladder.adapter.PlayerAdapter;
import hu.ait.android.smashladder.data.PlayerItem;

public class PlayerListActivity extends AppCompatActivity {

    private PlayerAdapter playerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);

        //List<ParseUser> playerUserList;

        final Context context = this;

        ParseQuery<ParseUser> query = ParseUser.getQuery();
        query.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> objects, ParseException e) {
                //playerUserList = objects;
                playerAdapter = new PlayerAdapter(objects, context);

                RecyclerView recyclerViewPlayerItem = (RecyclerView) findViewById(R.id.player_recycler_view);
                recyclerViewPlayerItem.setLayoutManager(new LinearLayoutManager(context));
                recyclerViewPlayerItem.setAdapter(playerAdapter);
                recyclerViewPlayerItem.setVisibility(View.VISIBLE);
            }
        });

        /*playerAdapter = new PlayerAdapter(playerUserList);

        RecyclerView recyclerViewPlayerItem = (RecyclerView) findViewById(R.id.player_recycler_view);
        recyclerViewPlayerItem.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPlayerItem.setAdapter(playerAdapter);*/


    }

}
