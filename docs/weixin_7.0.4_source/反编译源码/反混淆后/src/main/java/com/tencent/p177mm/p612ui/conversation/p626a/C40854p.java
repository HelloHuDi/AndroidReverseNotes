package com.tencent.p177mm.p612ui.conversation.p626a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C6685l;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p612ui.widget.imageview.WeImageView;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;
import com.tencent.p177mm.sdk.platformtools.C5058f;

/* renamed from: com.tencent.mm.ui.conversation.a.p */
public final class C40854p extends C14933b {
    private TextView gne;
    private View jyC;
    private View jyD;
    private boolean zwX = false;
    private WeImageView zxj;

    public C40854p(Context context) {
        super(context);
        AppMethodBeat.m2504i(34728);
        if (!(this.zwX || this.view == null)) {
            this.jyC = this.view.findViewById(2131824110);
            this.jyD = this.view.findViewById(2131821629);
            this.zxj = (WeImageView) this.view.findViewById(2131826452);
            this.zxj.setIconColor(((Context) this.vlu.get()).getResources().getColor(C25738R.color.a3_));
            this.gne = (TextView) this.view.findViewById(2131826453);
            this.zwX = true;
        }
        AppMethodBeat.m2505o(34728);
    }

    public final int getLayoutId() {
        return 2130970341;
    }

    public final int getOrder() {
        return 2;
    }

    public final void setVisibility(int i) {
        AppMethodBeat.m2504i(34729);
        if (this.jyC != null) {
            this.jyC.setVisibility(i);
        }
        AppMethodBeat.m2505o(34729);
    }

    public final void destroy() {
    }

    /* renamed from: k */
    private static boolean m70791k(Object obj, int i) {
        AppMethodBeat.m2504i(34731);
        if (obj == null) {
            AppMethodBeat.m2505o(34731);
            return true;
        } else if (((Integer) obj).intValue() != i) {
            AppMethodBeat.m2505o(34731);
            return true;
        } else {
            AppMethodBeat.m2505o(34731);
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
        AppMethodBeat.m2504i(34730);
        if (this.nfA && this.eVH) {
            this.jyD.setBackgroundResource(C25738R.drawable.a3h);
            this.jyC.setBackground(null);
            this.gne.setBackground(null);
        } else if (this.nfA) {
            this.jyD.setBackgroundResource(C25738R.drawable.f6802r9);
            this.jyC.setBackgroundResource(C25738R.drawable.b7t);
            this.gne.setBackgroundResource(C25738R.drawable.a_q);
        } else if (this.eVH) {
            this.jyD.setBackgroundResource(C25738R.drawable.f6802r9);
            this.jyC.setBackgroundResource(C25738R.drawable.a_q);
            this.gne.setBackground(null);
        } else {
            this.jyD.setBackgroundResource(C25738R.drawable.f6802r9);
            this.jyC.setBackground(null);
            this.gne.setBackgroundResource(C25738R.drawable.a_q);
        }
        C9638aw.m17190ZK();
        if (C18628c.m29074XI()) {
            C9638aw.m17190ZK();
            if (C6685l.m11103lW(C18628c.m29075XJ())) {
                C6300p Rg = C9638aw.m17182Rg();
                C9638aw.m17190ZK();
                Rg.mo14541a(new C6685l(C18628c.m29075XJ()), 0);
                z = false;
                if (z) {
                    setVisibility(8);
                } else {
                    setVisibility(0);
                }
                AppMethodBeat.m2505o(34730);
                return z;
            }
        }
        C9638aw.m17190ZK();
        if (!C18628c.m29074XI() || C42252ah.isNullOrNil(C6685l.fOO) || C6685l.ajg()) {
            if (C5058f.EX_DEVICE_LOGIN) {
                C9638aw.m17190ZK();
                if (C18628c.m29074XI()) {
                    int deviceType = C6685l.getDeviceType();
                    if (C6685l.ajf() == 0 && (deviceType == 2 || deviceType == 1)) {
                        this.view.setOnClickListener(null);
                        if (C40854p.m70791k(this.zxj.getTag(), C1318a.tipsbar_icon_default)) {
                            this.zxj.setTag(Integer.valueOf(C1318a.tipsbar_icon_default));
                            this.zxj.setImageResource(C1318a.tipsbar_icon_default);
                        }
                        if (deviceType == 2) {
                            this.gne.setText(C25738R.string.g7_);
                            z = true;
                        } else {
                            if (deviceType == 1) {
                                this.gne.setText(C25738R.string.g7a);
                            }
                            z = true;
                        }
                        if (z) {
                        }
                        AppMethodBeat.m2505o(34730);
                        return z;
                    }
                }
            }
            z = false;
            if (z) {
            }
            AppMethodBeat.m2505o(34730);
            return z;
        }
        if (C1853r.m3855ku(C1853r.m3824YF())) {
            if (C6685l.ajj() || !C6685l.ajh()) {
                this.gne.setText(C6685l.fOO);
            } else {
                this.gne.setText(C6685l.fOV);
            }
        } else if (C6685l.ajj() || !C6685l.ajh()) {
            this.gne.setText(C6685l.fOR);
        } else {
            this.gne.setText(C6685l.fOW);
        }
        this.zxj.setIconColor(((Context) this.vlu.get()).getResources().getColor(C25738R.color.a3_));
        if (C6685l.ajf() == 1) {
            if (C40854p.m70791k(this.zxj.getTag(), C1318a.icons_outlined_display)) {
                this.zxj.setTag(Integer.valueOf(C1318a.icons_outlined_display));
                this.zxj.setImageResource(C1318a.icons_outlined_display);
            }
        } else if (C6685l.ajf() == 2) {
            if (C6685l.ajh()) {
                if (C40854p.m70791k(this.zxj.getTag(), C1318a.icons_outlined_imac_lock)) {
                    this.zxj.setTag(Integer.valueOf(C1318a.icons_outlined_imac_lock));
                    this.zxj.setImageResource(C1318a.icons_outlined_imac_lock);
                }
            } else if (C40854p.m70791k(this.zxj.getTag(), C1318a.icons_outlined_imac)) {
                this.zxj.setTag(Integer.valueOf(C1318a.icons_outlined_imac));
                this.zxj.setImageResource(C1318a.icons_outlined_imac);
            }
        } else if (C6685l.ajf() == 3) {
            if (C40854p.m70791k(this.zxj.getTag(), C1318a.icons_outlined_pad)) {
                this.zxj.setTag(Integer.valueOf(C1318a.icons_outlined_pad));
                this.zxj.setImageResource(C1318a.icons_outlined_pad);
            }
        } else if (C40854p.m70791k(this.zxj.getTag(), C1318a.tipsbar_icon_default)) {
            this.zxj.setTag(Integer.valueOf(C1318a.tipsbar_icon_default));
            this.zxj.setImageResource(C1318a.tipsbar_icon_default);
        }
        final Intent intent = new Intent();
        intent.putExtra("intent.key.online_version", C6685l.aji());
        this.view.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(34727);
                C25985d.m41467b((Context) C40854p.this.vlu.get(), "webwx", ".ui.WebWXLogoutUI", intent);
                AppMethodBeat.m2505o(34727);
            }
        });
        z = true;
        if (z) {
        }
        AppMethodBeat.m2505o(34730);
        return z;
    }
}
