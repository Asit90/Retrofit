package cakart.cakart.in.retrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.List;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

   private Context context;
   private List<Item> items;

   public PostAdapter(Context context,List<Item>items){
       this.context=context;
       this.items=items;
   }


    @Override
    public PostViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.post_item,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder( PostViewHolder holder, int position) {
        Item item=items.get(position);
        holder.postTitle.setText(item.getTitle());


        Document document= Jsoup.parse(item.getContent());
        holder.postDescription.setText(document.text());
        Elements elements=document.select("img");
       // Log.d("CODE","Image -"+elements.get(0).attr("src"));
       // Log.d("TEXT",document.text());
        // 1st image come this code are use

     /*   Pattern p=Pattern.compile("<img[^>]*src=[\"']([^\"^']*)",
                Pattern.CASE_INSENSITIVE);
        Matcher m=p.matcher(item.getContent());
        Log.d("Akhil",item.getContent());
        List<String> tokens=new ArrayList<>();
        while (m.find()){
            Log.d("Akhil","Tok - "+m.group(1));
            String token=m.group(1);
            tokens.add(token);}*/
        if(elements.size()>0)
            Glide.with(context).load(elements.get(0).attr("src")).into(holder.postimage);
        }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        ImageView postimage;
        TextView postTitle,postDescription;
        public PostViewHolder(View itemView){
            super(itemView);
            postimage=(ImageView)itemView.findViewById(R.id.postImage);
            postTitle=(TextView)itemView.findViewById(R.id.postTitle);
            postDescription=(TextView)itemView.findViewById(R.id.postDescription);
        }
    }
}
