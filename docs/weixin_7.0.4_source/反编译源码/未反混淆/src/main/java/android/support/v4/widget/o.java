package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class o extends f {
    private int Rt;
    private int Ru;
    private LayoutInflater mInflater;

    @Deprecated
    public o(Context context, int i) {
        super(context);
        this.Ru = i;
        this.Rt = i;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.Rt, viewGroup, false);
    }

    public final View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.Ru, viewGroup, false);
    }
}
