package mikiponix.io.l4ssns;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CardAdapter extends ArrayAdapter<Card> {

    private List<Card> cards;

    private OnLikeClickListener likeClickListener = null;

    public CardAdapter(Context context, int resource, List<Card> cards) {
        super(context, resource, cards);

        this.cards = cards;
    }

    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public Card getCard(int position) {
        return cards.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.titleText = (TextView) convertView.findViewById(R.id.title_text);
            viewHolder.contentText = (TextView) convertView.findViewById(R.id.content_text);
            viewHolder.likeImage = (ImageView) convertView.findViewById(R.id.heart_icon);
            viewHolder.likeCountText = (TextView) convertView.findViewById(R.id.likecount);

            convertView.setTag(viewHolder);
        }

        Card card = cards.get(position);

        viewHolder.titleText.setText(card.getTitle());
        viewHolder.contentText.setText(card.getContent());
        viewHolder.likeCountText.setText(String.valueOf(card.getLikeCount()));
        viewHolder.likeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (likeClickListener != null) {
                    likeClickListener.onLikeClick(position);
                }
            }
        });

        return convertView;
    }

    public void setOnLikeClickListener(OnLikeClickListener likeClickListener) {
        this.likeClickListener = likeClickListener;
    }

    static class ViewHolder {
        TextView titleText;
        TextView contentText;
        ImageView likeImage;
        TextView likeCountText;
    }

    interface OnLikeClickListener {
        void onLikeClick(int position);
    }
}