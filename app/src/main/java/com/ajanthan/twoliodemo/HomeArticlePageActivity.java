package com.ajanthan.twoliodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class HomeArticlePageActivity extends AppCompatActivity {

    private RecyclerView rArticlesList;
    private ArticleHomeRecyclerViewAdapter redditHomeRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_listview);

        rArticlesList = (RecyclerView) findViewById(R.id.articleList);
        redditHomeRecyclerViewAdapter = new ArticleHomeRecyclerViewAdapter(this);
        rArticlesList.setAdapter(redditHomeRecyclerViewAdapter);
        rArticlesList.setLayoutManager(new LinearLayoutManager(this));
    }

}
