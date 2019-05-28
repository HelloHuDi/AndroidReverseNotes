package com.tencent.mm.pluginsdk.ui.chat;

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
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class i {
    Bitmap bitmap = null;
    ImageView cDh = null;
    private View contentView = null;
    private Context context;
    SharedPreferences ehZ;
    View jWH;
    View nOh;
    private h vor;
    g vos;
    o vot;
    boolean vou = true;
    com.tencent.mm.pluginsdk.ui.chat.h.a vov;
    a vow;

    public interface a {
        void ajI(String str);
    }

    public i(Context context, View view, View view2, a aVar) {
        AppMethodBeat.i(27960);
        this.context = context;
        this.jWH = view;
        this.nOh = view2;
        this.vor = new h(this.context);
        this.ehZ = context.getSharedPreferences(ah.doA(), 0);
        this.vow = aVar;
        this.contentView = View.inflate(this.context, R.layout.ld, null);
        this.cDh = (ImageView) this.contentView.findViewById(R.id.an6);
        this.vot = new o(this.contentView, -2, -2, true);
        this.vot.setBackgroundDrawable(new ColorDrawable(0));
        this.vot.setOutsideTouchable(true);
        this.contentView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27955);
                if (!(i.this.vow == null || i.this.vos == null)) {
                    i.this.vow.ajI(i.this.vos.vop);
                }
                i.this.vot.dismiss();
                AppMethodBeat.o(27955);
            }
        });
        AppMethodBeat.o(27960);
    }

    public final void dkJ() {
        AppMethodBeat.i(27961);
        final AnonymousClass2 anonymousClass2 = new ak(this.context.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(27956);
                i iVar = i.this;
                if (iVar.cDh == null || iVar.vos == null || iVar.bitmap == null || iVar.vot == null || iVar.jWH == null || iVar.nOh == null) {
                    AppMethodBeat.o(27956);
                    return;
                }
                iVar.cDh.setImageBitmap(iVar.bitmap);
                int i = iVar.vou ? 83 : 85;
                int i2 = iVar.vou ? 0 : 10;
                int yFromBottom = iVar.vov != null ? iVar.vov.getYFromBottom() : iVar.nOh.getHeight();
                if (VERSION.SDK_INT >= 21) {
                    Rect dze = ae.dze();
                    i2 = iVar.vou ? 0 : i2 + dze.right;
                    yFromBottom += dze.bottom;
                    ab.i("MicroMsg.RecentImageBubble", "recent bubble navbar height %s %s", Integer.valueOf(dze.right), Integer.valueOf(dze.bottom));
                }
                iVar.vot.showAtLocation(iVar.jWH, i, i2, yFromBottom);
                new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                    public final boolean BI() {
                        AppMethodBeat.i(27959);
                        i iVar = i.this;
                        if (iVar.vot != null) {
                            iVar.vot.dismiss();
                        }
                        AppMethodBeat.o(27959);
                        return false;
                    }
                }, false).ae(10000, 10000);
                AppMethodBeat.o(27956);
            }
        };
        aw.RS().aa(new Runnable() {
            public final void run() {
                int i;
                AppMethodBeat.i(27957);
                i iVar = i.this;
                String dkK = iVar.dkK();
                if (dkK == null) {
                    i = 0;
                } else {
                    int i2;
                    int Li = (int) iVar.Li(70);
                    int Li2 = (int) iVar.Li(120);
                    int bJ = ExifHelper.bJ(dkK);
                    if (bJ == 90 || bJ == 270) {
                        i = Li;
                        i2 = Li2;
                    } else {
                        i = Li2;
                        i2 = Li;
                    }
                    Li2 = (int) iVar.Li(4);
                    Bitmap d = d.d(dkK, i, i2, true);
                    if (d != null) {
                        iVar.bitmap = d.a(d.b(d, (float) bJ), true, (float) Li2);
                        iVar.ehZ.edit().putString("chattingui_recent_shown_image_path", iVar.vos.vop).commit();
                        ab.d("MicroMsg.RecentImageBubble", "check ok");
                        boolean i3 = true;
                    } else {
                        ab.e("MicroMsg.RecentImageBubble", "image hits hole.");
                        i3 = 0;
                    }
                }
                if (i3 != 0) {
                    anonymousClass2.sendEmptyMessage(0);
                    AppMethodBeat.o(27957);
                    return;
                }
                ab.d("MicroMsg.RecentImageBubble", "check false");
                AppMethodBeat.o(27957);
            }

            public final String toString() {
                AppMethodBeat.i(27958);
                String str = super.toString() + "|checkIfShow";
                AppMethodBeat.o(27958);
                return str;
            }
        });
        AppMethodBeat.o(27961);
    }

    /* Access modifiers changed, original: final */
    public final float Li(int i) {
        AppMethodBeat.i(27963);
        float applyDimension = TypedValue.applyDimension(1, (float) i, this.context.getResources().getDisplayMetrics());
        AppMethodBeat.o(27963);
        return applyDimension;
    }

    public final synchronized String dkK() {
        String str;
        g gVar;
        AppMethodBeat.i(27962);
        if (this.vor == null) {
            ab.d("MicroMsg.RecentImageBubble", "because of imageQuery == null");
            gVar = null;
        } else {
            ArrayList dkI = this.vor.dkI();
            if (dkI == null || dkI.size() == 0) {
                ab.d("MicroMsg.RecentImageBubble", "because of items == null || items.size() == 0");
                gVar = null;
            } else {
                Object obj;
                gVar = (g) dkI.get(0);
                if (gVar != null) {
                    if (bo.fp(gVar.voq) < 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        ab.e("MicroMsg.RecentImageBubble", "we found u have a future pic that lead to forbid this featur. file : %s", gVar.vop);
                        gVar = null;
                    }
                }
                if (gVar == null || gVar.vop == null || !gVar.vop.contains(e.eSm)) {
                    boolean z;
                    if (gVar != null) {
                        if (bo.fp(gVar.voq) <= 30) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            if (this.ehZ.getString("chattingui_recent_shown_image_path", "").equals(gVar.vop)) {
                                ab.d("MicroMsg.RecentImageBubble", "because of recentImage.equals(imageItem.orginalPath)");
                                gVar = null;
                            }
                        }
                    }
                    String str2 = "MicroMsg.RecentImageBubble";
                    String str3 = "because of checkAddDate(generateDate) == false, or imageItem == null : %s";
                    Object[] objArr = new Object[1];
                    if (gVar == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    ab.d(str2, str3, objArr);
                    gVar = null;
                } else {
                    gVar = null;
                }
            }
        }
        this.vos = gVar;
        if (this.vos == null) {
            AppMethodBeat.o(27962);
            str = null;
        } else {
            str = this.vos.thumbPath;
            if (this.vos.thumbPath == null) {
                str = this.vos.vop;
            }
            AppMethodBeat.o(27962);
        }
        return str;
    }
}
