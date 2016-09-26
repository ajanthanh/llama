package com.ajanthan.twoliodemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ajanthan on 15-11-26.
 */
public class ArticleHomeRecyclerViewAdapter extends RecyclerView.Adapter<ArticleHomeRecyclerViewAdapter.ArticleViewHolder> {

    private LayoutInflater mInflate;
    private ArrayList<Article> articles = new ArrayList<>();
    private Context mContext;
    private int current_postion;

    public ArticleHomeRecyclerViewAdapter(Context context) {
        mInflate = LayoutInflater.from(context);
        ArrayList articles = MessageModel.getInstance().getProcessedArticles();
        if(articles!=null){
            this.articles=articles;
        }
        mContext = context;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflate.inflate(R.layout.article_card, parent, false);
        ArticleViewHolder holder = new ArticleViewHolder(view, mContext);
        return holder;
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        holder.tvScore.setText(articles.get(position).getScore());
        holder.tvAuthor.setText(articles.get(position).getAuthor());
        holder.tvNumComments.setText(articles.get(position).getNumChildren()+""); //TODO hack
        holder.tvTitle.setText(articles.get(position).getText());
        current_postion = position;
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public void update(ArrayList<Article> addedArticles) {
        articles.addAll(addedArticles);
        notifyDataSetChanged();
    }

    public int getCurrent_postion() {
        return current_postion;
    }

    public ArrayList<Article> getArticles(){
        return articles;
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvScore;
        private TextView tvAuthor;
        private TextView tvTitle;
        private TextView tvNumComments;
        private Context context;
        private SharedPreferences prefs;

        public ArticleViewHolder(View itemView, Context context) {
            super(itemView);
            tvScore = (TextView) itemView.findViewById(R.id.score);
            tvAuthor = (TextView) itemView.findViewById(R.id.author);
            tvTitle = (TextView) itemView.findViewById(R.id.title);
            tvNumComments = (TextView) itemView.findViewById(R.id.numComments);
            this.context = context;
            prefs = context.getSharedPreferences("article", Context.MODE_PRIVATE);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // TODO: create request of article information
        }
    }
}
