package com.tencent.p177mm.pluginsdk.p597ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Message;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C30125h.C23290a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.pluginsdk.ui.chat.i */
public final class C23293i {
    Bitmap bitmap = null;
    ImageView cDh = null;
    private View contentView = null;
    private Context context;
    SharedPreferences ehZ;
    View jWH;
    View nOh;
    private C30125h vor;
    C23289g vos;
    C46633o vot;
    boolean vou = true;
    C23290a vov;
    C23292a vow;

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.i$4 */
    class C232914 implements C5015a {
        C232914() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(27959);
            C23293i c23293i = C23293i.this;
            if (c23293i.vot != null) {
                c23293i.vot.dismiss();
            }
            AppMethodBeat.m2505o(27959);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.i$a */
    public interface C23292a {
        void ajI(String str);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.i$1 */
    class C232961 implements OnClickListener {
        C232961() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27955);
            if (!(C23293i.this.vow == null || C23293i.this.vos == null)) {
                C23293i.this.vow.ajI(C23293i.this.vos.vop);
            }
            C23293i.this.vot.dismiss();
            AppMethodBeat.m2505o(27955);
        }
    }

    public C23293i(Context context, View view, View view2, C23292a c23292a) {
        AppMethodBeat.m2504i(27960);
        this.context = context;
        this.jWH = view;
        this.nOh = view2;
        this.vor = new C30125h(this.context);
        this.ehZ = context.getSharedPreferences(C4996ah.doA(), 0);
        this.vow = c23292a;
        this.contentView = View.inflate(this.context, 2130969023, null);
        this.cDh = (ImageView) this.contentView.findViewById(2131822438);
        this.vot = new C46633o(this.contentView, -2, -2, true);
        this.vot.setBackgroundDrawable(new ColorDrawable(0));
        this.vot.setOutsideTouchable(true);
        this.contentView.setOnClickListener(new C232961());
        AppMethodBeat.m2505o(27960);
    }

    public final void dkJ() {
        AppMethodBeat.m2504i(27961);
        final C232942 c232942 = new C7306ak(this.context.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(27956);
                C23293i c23293i = C23293i.this;
                if (c23293i.cDh == null || c23293i.vos == null || c23293i.bitmap == null || c23293i.vot == null || c23293i.jWH == null || c23293i.nOh == null) {
                    AppMethodBeat.m2505o(27956);
                    return;
                }
                c23293i.cDh.setImageBitmap(c23293i.bitmap);
                int i = c23293i.vou ? 83 : 85;
                int i2 = c23293i.vou ? 0 : 10;
                int yFromBottom = c23293i.vov != null ? c23293i.vov.getYFromBottom() : c23293i.nOh.getHeight();
                if (VERSION.SDK_INT >= 21) {
                    Rect dze = C5222ae.dze();
                    i2 = c23293i.vou ? 0 : i2 + dze.right;
                    yFromBottom += dze.bottom;
                    C4990ab.m7417i("MicroMsg.RecentImageBubble", "recent bubble navbar height %s %s", Integer.valueOf(dze.right), Integer.valueOf(dze.bottom));
                }
                c23293i.vot.showAtLocation(c23293i.jWH, i, i2, yFromBottom);
                new C7564ap(new C232914(), false).mo16770ae(10000, 10000);
                AppMethodBeat.m2505o(27956);
            }
        };
        C9638aw.m17180RS().mo10302aa(new Runnable() {
            public final void run() {
                int i;
                AppMethodBeat.m2504i(27957);
                C23293i c23293i = C23293i.this;
                String dkK = c23293i.dkK();
                if (dkK == null) {
                    i = 0;
                } else {
                    int i2;
                    int Li = (int) c23293i.mo39010Li(70);
                    int Li2 = (int) c23293i.mo39010Li(120);
                    int bJ = ExifHelper.m7368bJ(dkK);
                    if (bJ == 90 || bJ == 270) {
                        i = Li;
                        i2 = Li2;
                    } else {
                        i = Li2;
                        i2 = Li;
                    }
                    Li2 = (int) c23293i.mo39010Li(4);
                    Bitmap d = C5056d.m7659d(dkK, i, i2, true);
                    if (d != null) {
                        c23293i.bitmap = C5056d.m7616a(C5056d.m7648b(d, (float) bJ), true, (float) Li2);
                        c23293i.ehZ.edit().putString("chattingui_recent_shown_image_path", c23293i.vos.vop).commit();
                        C4990ab.m7410d("MicroMsg.RecentImageBubble", "check ok");
                        boolean i3 = true;
                    } else {
                        C4990ab.m7412e("MicroMsg.RecentImageBubble", "image hits hole.");
                        i3 = 0;
                    }
                }
                if (i3 != 0) {
                    c232942.sendEmptyMessage(0);
                    AppMethodBeat.m2505o(27957);
                    return;
                }
                C4990ab.m7410d("MicroMsg.RecentImageBubble", "check false");
                AppMethodBeat.m2505o(27957);
            }

            public final String toString() {
                AppMethodBeat.m2504i(27958);
                String str = super.toString() + "|checkIfShow";
                AppMethodBeat.m2505o(27958);
                return str;
            }
        });
        AppMethodBeat.m2505o(27961);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Li */
    public final float mo39010Li(int i) {
        AppMethodBeat.m2504i(27963);
        float applyDimension = TypedValue.applyDimension(1, (float) i, this.context.getResources().getDisplayMetrics());
        AppMethodBeat.m2505o(27963);
        return applyDimension;
    }

    public final synchronized String dkK() {
        String str;
        C23289g c23289g;
        AppMethodBeat.m2504i(27962);
        if (this.vor == null) {
            C4990ab.m7410d("MicroMsg.RecentImageBubble", "because of imageQuery == null");
            c23289g = null;
        } else {
            ArrayList dkI = this.vor.dkI();
            if (dkI == null || dkI.size() == 0) {
                C4990ab.m7410d("MicroMsg.RecentImageBubble", "because of items == null || items.size() == 0");
                c23289g = null;
            } else {
                Object obj;
                c23289g = (C23289g) dkI.get(0);
                if (c23289g != null) {
                    if (C5046bo.m7549fp(c23289g.voq) < 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        C4990ab.m7413e("MicroMsg.RecentImageBubble", "we found u have a future pic that lead to forbid this featur. file : %s", c23289g.vop);
                        c23289g = null;
                    }
                }
                if (c23289g == null || c23289g.vop == null || !c23289g.vop.contains(C6457e.eSm)) {
                    boolean z;
                    if (c23289g != null) {
                        if (C5046bo.m7549fp(c23289g.voq) <= 30) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            if (this.ehZ.getString("chattingui_recent_shown_image_path", "").equals(c23289g.vop)) {
                                C4990ab.m7410d("MicroMsg.RecentImageBubble", "because of recentImage.equals(imageItem.orginalPath)");
                                c23289g = null;
                            }
                        }
                    }
                    String str2 = "MicroMsg.RecentImageBubble";
                    String str3 = "because of checkAddDate(generateDate) == false, or imageItem == null : %s";
                    Object[] objArr = new Object[1];
                    if (c23289g == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    C4990ab.m7411d(str2, str3, objArr);
                    c23289g = null;
                } else {
                    c23289g = null;
                }
            }
        }
        this.vos = c23289g;
        if (this.vos == null) {
            AppMethodBeat.m2505o(27962);
            str = null;
        } else {
            str = this.vos.thumbPath;
            if (this.vos.thumbPath == null) {
                str = this.vos.vop;
            }
            AppMethodBeat.m2505o(27962);
        }
        return str;
    }
}
