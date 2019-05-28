package android.support.p057v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.widget.o */
public abstract class C31871o extends C41519f {
    /* renamed from: Rt */
    private int f14652Rt;
    /* renamed from: Ru */
    private int f14653Ru;
    private LayoutInflater mInflater;

    @Deprecated
    public C31871o(Context context, int i) {
        super(context);
        this.f14653Ru = i;
        this.f14652Rt = i;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.f14652Rt, viewGroup, false);
    }

    public final View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.f14653Ru, viewGroup, false);
    }
}
