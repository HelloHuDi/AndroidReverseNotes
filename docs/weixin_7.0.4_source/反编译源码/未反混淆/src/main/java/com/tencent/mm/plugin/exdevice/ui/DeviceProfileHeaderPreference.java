package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class DeviceProfileHeaderPreference extends Preference {
    private CharSequence JV;
    private String kWC;
    protected MMActivity knn;
    private ImageView lxS;
    private TextView lxT;
    private TextView lxU;
    private TextView lxV;
    private View lxW;
    private TextView lxX;
    private boolean[] lxY;
    private OnClickListener[] lxZ;
    private String lya;
    private boolean lyb;
    private String mDeviceName;

    public DeviceProfileHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(19759);
        this.lxY = new boolean[6];
        this.lxZ = new OnClickListener[6];
        this.lyb = false;
        this.knn = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.o(19759);
    }

    public DeviceProfileHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(19760);
        this.lxY = new boolean[6];
        this.lxZ = new OnClickListener[6];
        this.lyb = false;
        this.knn = (MMActivity) context;
        this.lyb = false;
        AppMethodBeat.o(19760);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(19761);
        ab.d("MicroMsg.DeviceProfileHeaderPreference", "onBindView");
        this.lxS = (ImageView) view.findViewById(R.id.bj0);
        this.lxT = (TextView) view.findViewById(R.id.bi_);
        this.lxU = (TextView) view.findViewById(R.id.bj2);
        this.lxV = (TextView) view.findViewById(R.id.bj3);
        this.lxW = view.findViewById(R.id.bj1);
        this.lxX = (TextView) view.findViewById(R.id.bj4);
        T(this.lxS, 0);
        T(this.lxT, 2);
        T(this.lxU, 1);
        T(this.lxV, 3);
        T(this.lxW, 4);
        T(this.lxX, 5);
        this.lyb = true;
        if (this.lyb) {
            this.lxT.setText(this.JV);
            this.lxV.setText(this.mDeviceName);
            this.lxX.setText(this.lya);
            jl(this.kWC);
        } else {
            ab.w("MicroMsg.DeviceProfileHeaderPreference", "initView : bindView = " + this.lyb);
        }
        super.onBindView(view);
        AppMethodBeat.o(19761);
    }

    private void T(View view, int i) {
        AppMethodBeat.i(19762);
        view.setVisibility(this.lxY[i] ? 8 : 0);
        view.setOnClickListener(this.lxZ[i]);
        AppMethodBeat.o(19762);
    }

    public final void Q(int i, boolean z) {
        View view;
        boolean z2;
        int i2 = 0;
        AppMethodBeat.i(19763);
        switch (i) {
            case 0:
                view = this.lxS;
                break;
            case 1:
                view = this.lxU;
                break;
            case 2:
                view = this.lxT;
                break;
            case 3:
                view = this.lxV;
                break;
            case 4:
                view = this.lxW;
                break;
            case 5:
                view = this.lxX;
                break;
            default:
                AppMethodBeat.o(19763);
                return;
        }
        boolean[] zArr = this.lxY;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        zArr[i] = z2;
        if (view != null) {
            if (!z) {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
        AppMethodBeat.o(19763);
    }

    public final void a(int i, OnClickListener onClickListener) {
        View view;
        AppMethodBeat.i(19764);
        switch (i) {
            case 0:
                view = this.lxS;
                break;
            case 1:
                view = this.lxU;
                break;
            case 2:
                view = this.lxT;
                break;
            case 3:
                view = this.lxV;
                break;
            case 4:
                view = this.lxW;
                break;
            case 5:
                view = this.lxX;
                break;
            default:
                AppMethodBeat.o(19764);
                return;
        }
        this.lxZ[i] = onClickListener;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(19764);
    }

    public final void setName(CharSequence charSequence) {
        AppMethodBeat.i(19765);
        this.JV = charSequence;
        if (this.lxT != null) {
            this.lxT.setText(charSequence);
        }
        AppMethodBeat.o(19765);
    }

    public final void Ky(String str) {
        AppMethodBeat.i(19766);
        this.mDeviceName = str;
        if (this.lxV != null) {
            this.lxV.setText(str);
        }
        AppMethodBeat.o(19766);
    }

    public final void jo(String str) {
        AppMethodBeat.i(19767);
        this.lya = str;
        if (this.lxX != null) {
            this.lxX.setText(str);
        }
        AppMethodBeat.o(19767);
    }

    public final void jl(String str) {
        AppMethodBeat.i(19768);
        this.kWC = str;
        if (this.lxS != null) {
            a aVar = new a();
            Bitmap LV = d.LV(R.drawable.ads);
            if (!(LV == null || LV.isRecycled())) {
                LV = d.a(LV, true, 0.5f * ((float) LV.getWidth()));
                if (!(LV == null || LV.isRecycled())) {
                    aVar.ePU = new BitmapDrawable(LV);
                }
            }
            if (LV == null || LV.isRecycled()) {
                aVar.ePT = R.drawable.ads;
            }
            aVar.eQf = true;
            o.ahp().a(this.kWC, this.lxS, aVar.ahG());
        }
        AppMethodBeat.o(19768);
    }
}
