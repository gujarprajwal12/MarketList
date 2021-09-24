package prajwal.gujar.barquecontech.come.marketlist;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.MarketViewHolder> {
    private Context mContext;
    private Cursor mCursor;

    public MarketAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
    }

    public class MarketViewHolder extends RecyclerView.ViewHolder {
        public TextView nameText;
        public TextView countText;

        public MarketViewHolder(View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.textview_name_item);
            countText = itemView.findViewById(R.id.textview_amount_item);
        }
    }

    @Override
    public MarketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.market_item, parent, false);
        return new MarketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MarketViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position)) {
            return;
        }

        String name = mCursor.getString(mCursor.getColumnIndex(MarketContract.MarketEntry.COLUMN_NAME));
        int amount = mCursor.getInt(mCursor.getColumnIndex(MarketContract.MarketEntry.COLUMN_AMOUNT));
        long id = mCursor.getLong(mCursor.getColumnIndex(MarketContract.MarketEntry._ID));

        holder.nameText.setText(name);
        holder.countText.setText(String.valueOf(amount));
        holder.itemView.setTag(id);
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount( );
    }

    public void swapCursor(Cursor newCursor) {
        if (mCursor != null) {
            mCursor.close( );
        }

        mCursor = newCursor;

        if (newCursor != null) {
            notifyDataSetChanged( );
        }
    }
}