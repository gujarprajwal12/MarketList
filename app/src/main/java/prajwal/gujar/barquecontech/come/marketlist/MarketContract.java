package prajwal.gujar.barquecontech.come.marketlist;

import android.provider.BaseColumns;

public class MarketContract {


    private MarketContract() {

    }


    public static final class MarketEntry implements BaseColumns {
        public static final String TABLE_NAME = "marketList";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_AMOUNT = "amount";
        public static final String COLUMN_TIMESTAMP = "timestamp";

        //timestamp are use for display the list in the view
    }
}