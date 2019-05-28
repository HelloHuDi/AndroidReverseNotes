package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class p extends b {
    private TextView gne;
    private View jyC;
    private View jyD;
    private boolean zwX = false;
    private WeImageView zxj;

    public p(Context context) {
        super(context);
        AppMethodBeat.i(34728);
        if (!(this.zwX || this.view == null)) {
            this.jyC = this.view.findViewById(R.id.bvd);
            this.jyD = this.view.findViewById(R.id.a2a);
            this.zxj = (WeImageView) this.view.findViewById(R.id.dkp);
            this.zxj.setIconColor(((Context) this.vlu.get()).getResources().getColor(R.color.a3_));
            this.gne = (TextView) this.view.findViewById(R.id.dkq);
            this.zwX = true;
        }
        AppMethodBeat.o(34728);
    }

    public final int getLayoutId() {
        return R.layout.ajv;
    }

    public final int getOrder() {
        return 2;
    }

    public final void setVisibility(int i) {
        AppMethodBeat.i(34729);
        if (this.jyC != null) {
            this.jyC.setVisibility(i);
        }
        AppMethodBeat.o(34729);
    }

    public final void destroy() {
    }

    private static boolean k(Object obj, int i) {
        AppMethodBeat.i(34731);
        if (obj == null) {
            AppMethodBeat.o(34731);
            return true;
        } else if (((Integer) obj).intValue() != i) {
            AppMethodBeat.o(34731);
            return true;
        } else {
            AppMethodBeat.o(34731);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:81:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean aMN() {
        boolean z;
        AppMethodBeat.i(34730);
        if (this.nfA && this.eVH) {
            this.jyD.setBackgroundResource(R.drawable.a3h);
            this.jyC.setBackground(null);
            this.gne.setBackground(null);
        } else if (this.nfA) {
            this.jyD.setBackgroundResource(R.drawable.r9);
            this.jyC.setBackgroundResource(R.drawable.b7t);
            this.gne.setBackgroundResource(R.drawable.a_q);
        } else if (this.eVH) {
            this.jyD.setBackgroundResource(R.drawable.r9);
            this.jyC.setBackgroundResource(R.drawable.a_q);
            this.gne.setBackground(null);
        } else {
            this.jyD.setBackgroundResource(R.drawable.r9);
            this.jyC.setBackground(null);
            this.gne.setBackgroundResource(R.drawable.a_q);
        }
        aw.ZK();
        if (c.XI()) {
            aw.ZK();
            if (l.lW(c.XJ())) {
                com.tencent.mm.ai.p Rg = aw.Rg();
                aw.ZK();
                Rg.a(new l(c.XJ()), 0);
                z = false;
                if (z) {
                    setVisibility(8);
                } else {
                    setVisibility(0);
                }
                AppMethodBeat.o(34730);
                return z;
            }
        }
        aw.ZK();
        if (!c.XI() || ah.isNullOrNil(l.fOO) || l.ajg()) {
            if (f.EX_DEVICE_LOGIN) {
                aw.ZK();
                if (c.XI()) {
                    int deviceType = l.getDeviceType();
                    if (l.ajf() == 0 && (deviceType == 2 || deviceType == 1)) {
                        this.view.setOnClickListener(null);
                        if (k(this.zxj.getTag(), R.raw.tipsbar_icon_default)) {
                            this.zxj.setTag(Integer.valueOf(R.raw.tipsbar_icon_default));
                            this.zxj.setImageResource(R.raw.tipsbar_icon_default);
                        }
                        if (deviceType == 2) {
                            this.gne.setText(R.string.g7_);
                            z = true;
                        } else {
                            if (deviceType == 1) {
                                this.gne.setText(R.string.g7a);
                            }
                            z = true;
                        }
                        if (z) {
                        }
                        AppMethodBeat.o(34730);
                        return z;
                    }
                }
            }
            z = false;
            if (z) {
            }
            AppMethodBeat.o(34730);
            return z;
        }
        if (r.ku(r.YF())) {
            if (l.ajj() || !l.ajh()) {
                this.gne.setText(l.fOO);
            } else {
                this.gne.setText(l.fOV);
            }
        } else if (l.ajj() || !l.ajh()) {
            this.gne.setText(l.fOR);
        } else {
            this.gne.setText(l.fOW);
        }
        this.zxj.setIconColor(((Context) this.vlu.get()).getResources().getColor(R.color.a3_));
        if (l.ajf() == 1) {
            if (k(this.zxj.getTag(), R.raw.icons_outlined_display)) {
                this.zxj.setTag(Integer.valueOf(R.raw.icons_outlined_display));
                this.zxj.setImageResource(R.raw.icons_outlined_display);
            }
        } else if (l.ajf() == 2) {
            if (l.ajh()) {
                if (k(this.zxj.getTag(), R.raw.icons_outlined_imac_lock)) {
                    this.zxj.setTag(Integer.valueOf(R.raw.icons_outlined_imac_lock));
                    this.zxj.setImageResource(R.raw.icons_outlined_imac_lock);
                }
            } else if (k(this.zxj.getTag(), R.raw.icons_outlined_imac)) {
                this.zxj.setTag(Integer.valueOf(R.raw.icons_outlined_imac));
                this.zxj.setImageResource(R.raw.icons_outlined_imac);
            }
        } else if (l.ajf() == 3) {
            if (k(this.zxj.getTag(), R.raw.icons_outlined_pad)) {
                this.zxj.setTag(Integer.valueOf(R.raw.icons_outlined_pad));
                this.zxj.setImageResource(R.raw.icons_outlined_pad);
            }
        } else if (k(this.zxj.getTag(), R.raw.tipsbar_icon_default)) {
            this.zxj.setTag(Integer.valueOf(R.raw.tipsbar_icon_default));
            this.zxj.setImageResource(R.raw.tipsbar_icon_default);
        }
        final Intent intent = new Intent();
        intent.putExtra("intent.key.online_version", l.aji());
        this.view.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(34727);
                d.b((Context) p.this.vlu.get(), "webwx", ".ui.WebWXLogoutUI", intent);
                AppMethodBeat.o(34727);
            }
        });
        z = true;
        if (z) {
        }
        AppMethodBeat.o(34730);
        return z;
    }
}
