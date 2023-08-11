package com.example.expandcollapsetoolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private FloatingActionButton floatingActionButton;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private Menu mmenu;
    private boolean isExpanded = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iNitView();
        iNitToolbar();
        iNitRecyclerView();
        iNitToolBarAnimation();
        onClickAdd();
    }

    private void iNitView() {
        appBarLayout = findViewById(R.id.id_appbarlayout);
        collapsingToolbarLayout = findViewById(R.id.id_collapsingtoolbarlayout);
        toolbar = findViewById(R.id.id_toolbar);
        floatingActionButton = findViewById(R.id.id_floatingbutton);
        recyclerView = findViewById(R.id.id_recycleview);

    }
    private void iNitToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    private void iNitRecyclerView(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userAdapter = new UserAdapter();
        userAdapter.setData(getListUser());
        recyclerView.setAdapter(userAdapter);
    }

    private List<User> getListUser() {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.anhgaixinh01,"Ngọc Huyền","TP.Hồ Chí Minh"));
        list.add(new User(R.drawable.anhgaixinh02,"Yến Nhi","TP.Hải Phòng"));
        list.add(new User(R.drawable.anhgaixinh03,"Trâm Anh","TP.Hạ Long"));
        list.add(new User(R.drawable.anhgaixinh04,"Quỳnh Nga","TP.Hạ Long"));
        list.add(new User(R.drawable.anhgaixinh05,"Như Ngọc","TP.Phan Thiết"));
        list.add(new User(R.drawable.anhleeminho,"Lee Min Hoo","Hàn Quốc"));
        list.add(new User(R.drawable.anhmessi,"Messi","Arhentina"));
        list.add(new User(R.drawable.anhronado,"Ronado","Bồ Đào Nha"));
        list.add(new User(R.drawable.anhneimar,"Neir Ma","Braxin"));
        return list;

    }
    private void iNitToolBarAnimation(){
        collapsingToolbarLayout.setTitle(getString(R.string.Name));
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.hinhnui);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                int myColor = palette.getVibrantColor(getResources().getColor(R.color.colorToolbar));
                collapsingToolbarLayout.setContentScrimColor(myColor);
                collapsingToolbarLayout.setStatusBarScrimColor(getResources().getColor(R.color.black_trans));

            }
        });
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(Math.abs(verticalOffset) > 200){
                    isExpanded = false;
                }
                else
                {
                    isExpanded = true;
                }
                invalidateOptionsMenu();
            }
        });
    }
    private void onClickAdd(){
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Click button add", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        mmenu = menu;
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if(mmenu != null && (!isExpanded || mmenu.size() != 1)){
            mmenu.add("Add").setIcon(R.drawable.baseline_add_24).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }
        else {

        }
        return super.onPrepareOptionsMenu(mmenu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getTitle() == "Add"){
            Toast.makeText(this, "Click add", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}