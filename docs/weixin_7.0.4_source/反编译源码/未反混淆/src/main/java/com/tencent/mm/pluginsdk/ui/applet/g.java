package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.api.h;
import com.tencent.mm.api.i;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a.b;
import com.tencent.mm.ui.widget.a.c.a.d;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class g implements q {
    private static int[] vkg = new int[]{R.id.b0r, R.id.b0s, R.id.b0t, R.id.b0u, R.id.b0v, R.id.b0w, R.id.b0x, R.id.b0y, R.id.b0z};

    public static class a {
        public c gud;
        public OnDismissListener jbD;
        Context mContext;
        final com.tencent.mm.ui.widget.a.c.a vkm;
        String vkn = null;

        public a(Context context) {
            AppMethodBeat.i(27657);
            this.mContext = context;
            this.vkm = new com.tencent.mm.ui.widget.a.c.a(this.mContext);
            this.vkm.rc(false);
            this.vkm.rd(false);
            this.vkm.a(new d() {
                public final CharSequence a(CharSequence charSequence, float f) {
                    AppMethodBeat.i(27656);
                    SpannableString a = ((com.tencent.mm.plugin.emoji.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.emoji.b.a.class)).a(a.this.mContext, charSequence, f);
                    AppMethodBeat.o(27656);
                    return a;
                }
            });
            AppMethodBeat.o(27657);
        }

        public final a cx(Object obj) {
            AppMethodBeat.i(27658);
            g.b(this.mContext, this.vkm, obj);
            this.vkm.ra(true);
            AppMethodBeat.o(27658);
            return this;
        }

        public final a djw() {
            AppMethodBeat.i(27659);
            this.vkm.Qa(2);
            AppMethodBeat.o(27659);
            return this;
        }

        public final a ajC(String str) {
            AppMethodBeat.i(27660);
            int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(this.mContext, (int) (14.0f * com.tencent.mm.bz.a.dm(this.mContext)));
            if (!bo.isNullOrNil(str)) {
                this.vkm.ak(((com.tencent.mm.plugin.emoji.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, str.toString(), (float) fromDPToPix));
            }
            AppMethodBeat.o(27660);
            return this;
        }

        public final a ajD(String str) {
            AppMethodBeat.i(27661);
            this.vkm.asF(str);
            AppMethodBeat.o(27661);
            return this;
        }

        public final a djx() {
            this.vkm.zQe.zPy = 8;
            return this;
        }

        public final a b(Bitmap bitmap, int i) {
            AppMethodBeat.i(27662);
            this.vkm.a(bitmap, true, i);
            this.vkm.ra(false);
            g.b(this.vkm, bitmap);
            AppMethodBeat.o(27662);
            return this;
        }

        public final a ajE(String str) {
            AppMethodBeat.i(27663);
            g.a(this.mContext, this.vkm, str);
            this.vkm.ra(false);
            AppMethodBeat.o(27663);
            return this;
        }

        public final a a(b bVar) {
            AppMethodBeat.i(27664);
            this.vkm.b(bVar);
            AppMethodBeat.o(27664);
            return this;
        }

        public final a ev(View view) {
            AppMethodBeat.i(27665);
            this.vkm.fn(view);
            AppMethodBeat.o(27665);
            return this;
        }

        public final a h(Boolean bool) {
            AppMethodBeat.i(27666);
            this.vkm.rb(bool.booleanValue());
            if (bool.booleanValue()) {
                this.vkm.asH(this.mContext.getString(R.string.atc));
            }
            AppMethodBeat.o(27666);
            return this;
        }

        public final a djy() {
            AppMethodBeat.i(27667);
            this.vkm.ra(false);
            AppMethodBeat.o(27667);
            return this;
        }

        public final a KQ(int i) {
            AppMethodBeat.i(27668);
            this.vkn = this.mContext.getResources().getString(i);
            AppMethodBeat.o(27668);
            return this;
        }

        public final a a(com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
            AppMethodBeat.i(27669);
            this.gud = this.vkm.aMb();
            if (this.jbD != null) {
                this.gud.setOnDismissListener(this.jbD);
            }
            g.a(this.mContext, this.gud, this.vkn, aVar, aVar);
            AppMethodBeat.o(27669);
            return this;
        }
    }

    static /* synthetic */ void b(Context context, com.tencent.mm.ui.widget.a.c.a aVar, Object obj) {
        AppMethodBeat.i(27704);
        a(context, aVar, obj);
        AppMethodBeat.o(27704);
    }

    private static void a(Context context, com.tencent.mm.ui.widget.a.c.a aVar, Object obj) {
        AppMethodBeat.i(27670);
        if (obj != null) {
            List P;
            if (obj instanceof String) {
                P = bo.P(((String) obj).split(","));
            } else if (obj instanceof List) {
                P = (List) obj;
            } else {
                P = null;
            }
            if (bo.ek(P)) {
                AppMethodBeat.o(27670);
                return;
            } else if (P.size() == 1) {
                final String str = (String) P.get(0);
                int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(context, (int) (20.0f * com.tencent.mm.bz.a.dm(context)));
                aVar.ai(((com.tencent.mm.plugin.emoji.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.emoji.b.a.class)).a(context, context.getString(R.string.dr6).toString(), (float) fromDPToPix)).PY(3);
                String mJ = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.a.b.class)).mJ(str);
                int fromDPToPix2 = com.tencent.mm.bz.a.fromDPToPix(context, (int) (14.0f * com.tencent.mm.bz.a.dm(context)));
                if (t.kH(str)) {
                    SpannableString a = ((com.tencent.mm.plugin.emoji.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.emoji.b.a.class)).a(context, (mJ + context.getString(R.string.e1l, new Object[]{Integer.valueOf(((com.tencent.mm.plugin.chatroom.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.chatroom.a.b.class)).mA(str))})).toString(), (float) fromDPToPix2);
                    final View inflate = v.hu(context).inflate(R.layout.si, null);
                    GridView gridView = (GridView) inflate.findViewById(R.id.b_o);
                    final ArrayList arrayList = new ArrayList();
                    final List my = ((com.tencent.mm.plugin.chatroom.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.chatroom.a.b.class)).my(str);
                    aVar.a(str, a, Boolean.TRUE, new com.tencent.mm.ui.widget.a.c.a.c() {
                        public final void djv() {
                            AppMethodBeat.i(27639);
                            bo.hideVKB(inflate);
                            if (arrayList.size() == 0 && !bo.isNullOrNil(str)) {
                                g.a(arrayList, my);
                            }
                            AppMethodBeat.o(27639);
                        }
                    }, new com.tencent.mm.ui.widget.a.c.a.a() {
                        public final void u(ImageView imageView, String str) {
                            AppMethodBeat.i(27645);
                            com.tencent.mm.ui.e.a.a.b(imageView, str);
                            AppMethodBeat.o(27645);
                        }
                    });
                    gridView.setAdapter(new l(context, my, arrayList));
                    gridView.setSelector(new ColorDrawable(context.getResources().getColor(R.color.a3p)));
                    if (my != null) {
                        if (my.size() > 16) {
                            gridView.setLayoutParams(new LayoutParams(-1, com.tencent.mm.bz.a.al(context, R.dimen.fq)));
                            gridView.setPadding(com.tencent.mm.bz.a.al(context, R.dimen.fm), 0, com.tencent.mm.bz.a.al(context, R.dimen.fm), 0);
                        } else {
                            gridView.setPadding(0, 0, 0, com.tencent.mm.bz.a.al(context, R.dimen.fj));
                        }
                    }
                    aVar.zQe.zPt = inflate;
                    AppMethodBeat.o(27670);
                    return;
                }
                aVar.a(str, ((com.tencent.mm.plugin.emoji.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.emoji.b.a.class)).a(context, mJ.toString(), (float) fromDPToPix2), Boolean.FALSE, null, new com.tencent.mm.ui.widget.a.c.a.a() {
                    public final void u(ImageView imageView, String str) {
                        AppMethodBeat.i(27649);
                        com.tencent.mm.ui.e.a.a.b(imageView, str);
                        AppMethodBeat.o(27649);
                    }
                });
                AppMethodBeat.o(27670);
                return;
            } else {
                aVar.zQe.zPs = d(context, P);
                aVar.asD(context.getString(R.string.d1w)).PY(3);
            }
        }
        AppMethodBeat.o(27670);
    }

    private static View d(Context context, List<String> list) {
        AppMethodBeat.i(27671);
        View inflate = View.inflate(context, R.layout.pv, null);
        if (list != null) {
            int i = 0;
            for (String str : list) {
                if (i <= 8 && inflate != null) {
                    ImageView imageView = (ImageView) inflate.findViewById(vkg[i]);
                    if (str != null) {
                        imageView.setVisibility(0);
                        com.tencent.mm.ui.e.a.a.b(imageView, str);
                        i++;
                    }
                }
                i = i;
            }
        }
        AppMethodBeat.o(27671);
        return inflate;
    }

    private static void a(Context context, final c cVar, String str, String str2, final com.tencent.mm.pluginsdk.ui.applet.q.a aVar, final com.tencent.mm.pluginsdk.ui.applet.q.a aVar2) {
        CharSequence str3;
        CharSequence str22;
        String str4 = null;
        AppMethodBeat.i(27672);
        if (bo.isNullOrNil(str3) || str3.length() == 0) {
            str3 = context.getResources().getString(R.string.atf);
        }
        if (bo.isNullOrNil(str4) || str4.length() == 0) {
            str22 = context.getResources().getString(R.string.or);
        }
        cVar.a(str3, true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(27650);
                cVar.dismiss();
                if (aVar != null) {
                    aVar.a(true, cVar.dKV(), cVar.dKW());
                }
                AppMethodBeat.o(27650);
            }
        });
        cVar.b(str22, true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(27651);
                cVar.dismiss();
                if (aVar2 != null) {
                    aVar2.a(false, null, 0);
                }
                AppMethodBeat.o(27651);
            }
        });
        AppMethodBeat.o(27672);
    }

    public static c a(q qVar, String str, String str2, String str3, boolean z, String str4, com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
        AppMethodBeat.i(27673);
        if ((str == null || str.length() == 0) && (str3 == null || str3.length() == 0)) {
            ab.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            AppMethodBeat.o(27673);
            return null;
        }
        View inflate = View.inflate(qVar.ylL, R.layout.po, null);
        com.tencent.mm.ui.widget.a.c.a aVar2 = new com.tencent.mm.ui.widget.a.c.a(qVar.ylL);
        aVar2.rc(false);
        aVar2.rd(false);
        a(aVar2, qVar.ylL, str);
        u(inflate, z);
        a(qVar, aVar2, aVar, inflate, str4);
        TextView textView = (TextView) inflate.findViewById(R.id.b0a);
        textView.setText(j.b(qVar.ylL, (CharSequence) str3, textView.getTextSize()));
        inflate.findViewById(R.id.b0b).setVisibility(8);
        int b = BackwardSupportUtil.b.b(qVar.ylL, 120.0f);
        CdnImageView cdnImageView = (CdnImageView) inflate.findViewById(R.id.b0_);
        if (cdnImageView != null) {
            cdnImageView.am(str2, b, b);
        }
        aVar2.fn(inflate);
        c aMb = aVar2.aMb();
        aMb.show();
        AppMethodBeat.o(27673);
        return aMb;
    }

    public static c a(q qVar, String str, String str2, boolean z, String str3, com.tencent.mm.pluginsdk.ui.applet.q.a aVar, String str4) {
        AppMethodBeat.i(27675);
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            ab.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            AppMethodBeat.o(27675);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar2 = new com.tencent.mm.ui.widget.a.c.a(qVar.ylL);
        String string = qVar.ylL.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(qVar.ylL, aVar2, bo.P(string.split(",")));
        }
        aVar2.ra(true);
        aVar2.ak(str).rc(false).rd(false);
        if (z) {
            aVar2.rb(true);
        }
        c aMb = aVar2.aMb();
        a(qVar.ylL, aMb, str3, null, aVar, aVar);
        aMb.show();
        AppMethodBeat.o(27675);
        return aMb;
    }

    public static c b(q qVar, String str, String str2, String str3, String str4, String str5, com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
        AppMethodBeat.i(27676);
        if ((str == null || str.length() == 0) && (str3 == null || str3.length() == 0)) {
            ab.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            AppMethodBeat.o(27676);
            return null;
        }
        View inflate = View.inflate(qVar.ylL, R.layout.po, null);
        com.tencent.mm.ui.widget.a.c.a aVar2 = new com.tencent.mm.ui.widget.a.c.a(qVar.ylL);
        aVar2.rc(false);
        aVar2.rd(false);
        a(aVar2, qVar.ylL, str);
        if (inflate != null) {
            EditText editText = (EditText) inflate.findViewById(R.id.b09);
            if (editText != null) {
                editText.setVisibility(0);
            }
            editText.setText(str4);
        }
        a(qVar, aVar2, aVar, inflate, str5);
        TextView textView = (TextView) inflate.findViewById(R.id.b0a);
        textView.setText(j.b(qVar.ylL, (CharSequence) str3, textView.getTextSize()));
        inflate.findViewById(R.id.b0b).setVisibility(8);
        int b = BackwardSupportUtil.b.b(qVar.ylL, 120.0f);
        CdnImageView cdnImageView = (CdnImageView) inflate.findViewById(R.id.b0_);
        if (cdnImageView != null) {
            cdnImageView.am(str2, b, b);
        }
        aVar2.fn(inflate);
        c aMb = aVar2.aMb();
        aMb.show();
        AppMethodBeat.o(27676);
        return aMb;
    }

    public static c a(q qVar, String str, String str2, com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
        AppMethodBeat.i(27677);
        c a = a(qVar, str, str2, false, "", aVar);
        AppMethodBeat.o(27677);
        return a;
    }

    public static c a(q qVar, String str, boolean z, com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
        AppMethodBeat.i(27678);
        c a = a(qVar, str, z, "", aVar);
        AppMethodBeat.o(27678);
        return a;
    }

    public static c a(q qVar, String str, boolean z, String str2, com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
        AppMethodBeat.i(27679);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.MMConfirmDialog", "showDialogItem2 fail, message is empty");
            AppMethodBeat.o(27679);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar2 = new com.tencent.mm.ui.widget.a.c.a(qVar.ylL);
        String string = qVar.ylL.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(qVar.ylL, aVar2, bo.P(string.split(",")));
        }
        aVar2.ra(true);
        aVar2.ak(str).rc(false).rd(false);
        if (z) {
            aVar2.rb(true);
        }
        c aMb = aVar2.aMb();
        a(qVar.ylL, aMb, str2, null, aVar, aVar);
        aMb.show();
        AppMethodBeat.o(27679);
        return aMb;
    }

    public static c b(q qVar, String str, boolean z, com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
        AppMethodBeat.i(27680);
        c b = b(qVar, str, z, "", aVar);
        AppMethodBeat.o(27680);
        return b;
    }

    public static c b(q qVar, String str, boolean z, String str2, com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
        AppMethodBeat.i(27681);
        if (str == null || !e.ct(str)) {
            ab.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, img does not exist");
            AppMethodBeat.o(27681);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar2 = new com.tencent.mm.ui.widget.a.c.a(qVar.ylL);
        String string = qVar.ylL.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(qVar.ylL, aVar2, bo.P(string.split(",")));
        }
        aVar2.ra(true);
        aVar2.rc(false).rd(false);
        if (z) {
            aVar2.rb(true);
        }
        if (!bo.isNullOrNil(str)) {
            Bitmap aml = com.tencent.mm.sdk.platformtools.d.aml(str);
            int bJ = ExifHelper.bJ(str);
            if (aml != null) {
                if (bJ != 0) {
                    aml = com.tencent.mm.sdk.platformtools.d.b(aml, (float) bJ);
                }
                aVar2.a(aml, true, 3);
                a(aVar2, aml);
                aVar2.ra(false);
            }
        }
        c aMb = aVar2.aMb();
        a(qVar.ylL, aMb, str2, null, aVar, aVar);
        aMb.show();
        AppMethodBeat.o(27681);
        return aMb;
    }

    public static c a(q qVar, byte[] bArr, boolean z, com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
        AppMethodBeat.i(27682);
        c a = a(qVar, bArr, z, "", aVar);
        AppMethodBeat.o(27682);
        return a;
    }

    public static c a(q qVar, byte[] bArr, boolean z, String str, com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
        AppMethodBeat.i(27683);
        if (bArr == null || bArr.length == 0) {
            ab.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, imgData is null");
            AppMethodBeat.o(27683);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar2 = new com.tencent.mm.ui.widget.a.c.a(qVar.ylL);
        String string = qVar.ylL.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(qVar.ylL, aVar2, bo.P(string.split(",")));
        }
        aVar2.ra(true);
        aVar2.rc(false).rd(false);
        if (z) {
            aVar2.rb(true);
        }
        if (bArr != null && bArr.length > 0) {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            int cs = com.tencent.util.d.cs(bArr);
            if (decodeByteArray != null) {
                if (cs != 0) {
                    decodeByteArray = com.tencent.mm.sdk.platformtools.d.b(decodeByteArray, (float) cs);
                }
                aVar2.a(decodeByteArray, true, 3);
                a(aVar2, decodeByteArray);
                aVar2.ra(false);
            }
        }
        c aMb = aVar2.aMb();
        a(qVar.ylL, aMb, str, null, aVar, aVar);
        aMb.show();
        AppMethodBeat.o(27683);
        return aMb;
    }

    public static c a(q qVar, int i, String str, boolean z, com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
        AppMethodBeat.i(27684);
        c a = a(qVar, i, str, z, "", aVar);
        AppMethodBeat.o(27684);
        return a;
    }

    public static c a(q qVar, int i, String str, boolean z, String str2, com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
        AppMethodBeat.i(27685);
        com.tencent.mm.ui.widget.a.c.a aVar2 = new com.tencent.mm.ui.widget.a.c.a(qVar.ylL);
        String string = qVar.ylL.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(qVar.ylL, aVar2, bo.P(string.split(",")));
        }
        aVar2.ra(true);
        if (i == R.raw.app_attach_file_icon_file) {
            string = qVar.ylL.getResources().getString(R.string.qr);
        } else if (i == R.raw.app_attach_file_icon_music) {
            string = qVar.ylL.getResources().getString(R.string.rs);
        } else if (i == R.raw.app_attach_file_icon_video) {
            string = qVar.ylL.getResources().getString(R.string.ud);
        } else {
            string = qVar.ylL.getResources().getString(R.string.fy);
        }
        aVar2.ak(str).rc(false).rd(false);
        if (z) {
            aVar2.rb(true);
        }
        c aMb = aVar2.aMb();
        a(qVar.ylL, aMb, str2, null, aVar, aVar);
        aMb.show();
        AppMethodBeat.o(27685);
        return aMb;
    }

    public static c a(q qVar, String str, boolean z, int i, com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
        AppMethodBeat.i(27686);
        c a = a(qVar, str, z, i, "", aVar);
        AppMethodBeat.o(27686);
        return a;
    }

    public static c a(q qVar, String str, boolean z, int i, String str2, com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
        Object P;
        AppMethodBeat.i(27687);
        com.tencent.mm.ui.widget.a.c.a aVar2 = new com.tencent.mm.ui.widget.a.c.a(qVar.ylL);
        String string = qVar.ylL.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            P = bo.P(string.split(","));
        } else {
            P = null;
        }
        a(qVar.ylL, aVar2, P);
        aVar2.ra(true);
        switch (i) {
            case 1:
                string = qVar.ylL.getResources().getString(R.string.ud);
                break;
            case 2:
                string = qVar.ylL.getResources().getString(R.string.rs);
                break;
            default:
                string = qVar.ylL.getResources().getString(R.string.fy);
                break;
        }
        aVar2.ak(new StringBuffer(string).append(str).toString()).rc(false).rd(false);
        if (z) {
            aVar2.rb(true);
        }
        c aMb = aVar2.aMb();
        a(qVar.ylL, aMb, str2, null, aVar, aVar);
        aMb.show();
        AppMethodBeat.o(27687);
        return aMb;
    }

    public static c a(q qVar, String str, Bitmap bitmap, String str2, String str3, com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
        AppMethodBeat.i(27689);
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            ab.e("MicroMsg.MMConfirmDialog", "showDialogItem6 fail, title message both are empty");
            AppMethodBeat.o(27689);
            return null;
        }
        View ah = ah(qVar.ylL, R.layout.pq);
        com.tencent.mm.ui.widget.a.c.a aVar2 = new com.tencent.mm.ui.widget.a.c.a(qVar.ylL);
        aVar2.rc(false);
        aVar2.rd(false);
        u(ah, false);
        a(qVar, aVar2, aVar, ah, qVar.ylL.getResources().getString(R.string.au4));
        TextView textView = (TextView) ah.findViewById(R.id.b0f);
        textView.setText(j.b(qVar.ylL, (CharSequence) str, textView.getTextSize()));
        textView = (TextView) ah.findViewById(R.id.b0a);
        textView.setText(j.b(qVar.ylL, (CharSequence) str2, textView.getTextSize()));
        if (str3.length() == 0) {
            ah.findViewById(R.id.b0b).setVisibility(8);
        } else {
            ((TextView) ah.findViewById(R.id.b0b)).setText(str3);
        }
        ImageView imageView = (ImageView) ah.findViewById(R.id.b0_);
        if (imageView != null) {
            if (bitmap == null || bitmap.isRecycled()) {
                imageView.setVisibility(4);
            } else {
                imageView.setImageBitmap(bitmap);
                a(aVar2, bitmap);
            }
        }
        aVar2.fn(ah);
        c aMb = aVar2.aMb();
        aMb.show();
        AppMethodBeat.o(27689);
        return aMb;
    }

    public static void a(q qVar, String str, String str2, String str3, com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
        AppMethodBeat.i(27693);
        a h = new a(qVar.ylL).cx(str).ajC(str2).h(Boolean.FALSE);
        h.vkn = str3;
        h.a(aVar).gud.show();
        AppMethodBeat.o(27693);
    }

    public static c a(q qVar, String str, View view, String str2, final q.b bVar) {
        AppMethodBeat.i(27694);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            AppMethodBeat.o(27694);
            return null;
        }
        com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(qVar.ylL);
        aVar.rc(false);
        aVar.rd(false);
        a(aVar, qVar.ylL, str);
        if (bo.isNullOrNil(str2) || str2.length() == 0) {
            str2 = qVar.ylL.getResources().getString(R.string.atf);
        }
        aVar.asJ(str2).a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(27641);
                if (bVar != null) {
                    bVar.iw(true);
                }
                AppMethodBeat.o(27641);
            }
        });
        aVar.Qd(R.string.or).b(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(27642);
                if (bVar != null) {
                    bVar.iw(false);
                }
                AppMethodBeat.o(27642);
            }
        });
        aVar.fn(view);
        c aMb = aVar.aMb();
        aMb.PT(qVar.ylL.getResources().getColor(R.color.hi));
        aMb.show();
        AppMethodBeat.o(27694);
        return aMb;
    }

    private static View ah(Context context, int i) {
        AppMethodBeat.i(27695);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, null);
        AppMethodBeat.o(27695);
        return inflate;
    }

    private static o es(View view) {
        AppMethodBeat.i(27696);
        o oVar = new o(view, -1, -1);
        AppMethodBeat.o(27696);
        return oVar;
    }

    private static void a(q qVar, com.tencent.mm.ui.widget.a.c.a aVar, final com.tencent.mm.pluginsdk.ui.applet.q.a aVar2, final View view, String str) {
        AppMethodBeat.i(27697);
        if (bo.isNullOrNil(str) || str.length() == 0) {
            str = qVar.ylL.getResources().getString(R.string.atf);
        }
        aVar.asJ(str).a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(27655);
                if (aVar2 != null) {
                    aVar2.a(true, g.et(view), g.eu(view));
                }
                AppMethodBeat.o(27655);
            }
        });
        aVar.Qd(R.string.or).b(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(27640);
                if (aVar2 != null) {
                    aVar2.a(false, null, 0);
                }
                AppMethodBeat.o(27640);
            }
        });
        AppMethodBeat.o(27697);
    }

    private static void a(com.tencent.mm.ui.widget.a.c.a aVar, Context context, String str) {
        AppMethodBeat.i(27698);
        aVar.asD(str);
        aVar.PW(context.getResources().getColor(R.color.w4));
        aVar.PX(2);
        AppMethodBeat.o(27698);
    }

    private static void a(final View view, final com.tencent.mm.pluginsdk.ui.applet.q.a aVar, final o oVar) {
        AppMethodBeat.i(27699);
        ((Button) view.findViewById(R.id.b03)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27643);
                if (aVar != null) {
                    aVar.a(true, g.et(view), g.eu(view));
                }
                oVar.dismiss();
                oVar.setFocusable(false);
                oVar.setTouchable(false);
                AppMethodBeat.o(27643);
            }
        });
        Button button = (Button) view.findViewById(R.id.b02);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(27644);
                    if (aVar != null) {
                        aVar.a(false, null, 0);
                    }
                    oVar.dismiss();
                    oVar.setFocusable(false);
                    oVar.setTouchable(false);
                    AppMethodBeat.o(27644);
                }
            });
        }
        AppMethodBeat.o(27699);
    }

    private static void u(View view, boolean z) {
        AppMethodBeat.i(27700);
        if (view != null) {
            EditText editText = (EditText) view.findViewById(R.id.b09);
            if (editText != null) {
                editText.setVisibility(z ? 0 : 8);
            }
        }
        AppMethodBeat.o(27700);
    }

    private static void a(View view, int i, String str, boolean z, int i2) {
        AppMethodBeat.i(27701);
        TextView textView = (TextView) view.findViewById(i);
        Assert.assertTrue(textView != null);
        if (z && bo.isNullOrNil(str)) {
            textView.setVisibility(i2);
            AppMethodBeat.o(27701);
            return;
        }
        textView.setText(str);
        AppMethodBeat.o(27701);
    }

    private static void a(com.tencent.mm.ui.widget.a.c.a aVar, final Bitmap bitmap) {
        AppMethodBeat.i(27703);
        aVar.a(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(27647);
                if (bitmap == null || bitmap.isRecycled()) {
                    AppMethodBeat.o(27647);
                } else {
                    AppMethodBeat.o(27647);
                }
            }
        });
        AppMethodBeat.o(27703);
    }

    public static c a(q qVar, String str, String str2, boolean z, String str3, com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
        AppMethodBeat.i(27674);
        c a = a(qVar, str, str2, z, str3, aVar, qVar.ylL.getResources().getString(R.string.u9));
        AppMethodBeat.o(27674);
        return a;
    }

    public static c a(q qVar, Bitmap bitmap, String str, String str2, String str3, com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
        AppMethodBeat.i(27688);
        View ah = ah(qVar.ylL, R.layout.pp);
        com.tencent.mm.ui.widget.a.c.a aVar2 = new com.tencent.mm.ui.widget.a.c.a(qVar.ylL);
        aVar2.rc(false);
        aVar2.rd(false);
        u(ah, true);
        a(qVar, aVar2, aVar, ah, qVar.ylL.getResources().getString(R.string.atf));
        TextView textView = (TextView) ah.findViewById(R.id.b0f);
        textView.setText(j.b(qVar.ylL, (CharSequence) str, textView.getTextSize()));
        textView = (TextView) ah.findViewById(R.id.b0a);
        textView.setText(j.b(qVar.ylL, (CharSequence) str2, textView.getTextSize()));
        textView = (TextView) ah.findViewById(R.id.b0b);
        if (str3 == null || str3.length() == 0) {
            textView.setVisibility(8);
        } else {
            textView.setText(str3);
            textView.setVisibility(0);
        }
        ImageView imageView = (ImageView) ah.findViewById(R.id.b0_);
        if (imageView != null) {
            if (bitmap == null || bitmap.isRecycled()) {
                ab.w("MicroMsg.MMConfirmDialog", "showDialogItem4, thumbBmp is null or recycled");
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap);
                a(aVar2, bitmap);
            }
        }
        aVar2.fn(ah);
        c aMb = aVar2.aMb();
        aMb.show();
        AppMethodBeat.o(27688);
        return aMb;
    }

    public static o a(q qVar, final Bitmap bitmap, String str, final com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
        AppMethodBeat.i(27690);
        final View ah = ah(qVar.ylL, R.layout.pr);
        final o es = es(ah);
        a(ah, aVar, es);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MMConfirmDialog", "showDialogItem7 fail, message is empty");
            AppMethodBeat.o(27690);
            return null;
        }
        TextView textView = (TextView) ah.findViewById(R.id.b0a);
        textView.setText(j.b(qVar.ylL, (CharSequence) str, textView.getTextSize()));
        Button button = (Button) ah.findViewById(R.id.b03);
        ImageView imageView = (ImageView) ah.findViewById(R.id.b0_);
        if (imageView != null) {
            if (bitmap == null || bitmap.isRecycled()) {
                imageView.setVisibility(8);
            } else {
                imageView.setImageBitmap(bitmap);
                es.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    public final void onDismiss() {
                        AppMethodBeat.i(27646);
                        if (bitmap == null || bitmap.isRecycled()) {
                            AppMethodBeat.o(27646);
                        } else {
                            AppMethodBeat.o(27646);
                        }
                    }
                });
            }
        }
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27652);
                if (aVar != null) {
                    aVar.a(true, g.et(ah), g.eu(ah));
                }
                es.dismiss();
                es.setFocusable(false);
                es.setTouchable(false);
                AppMethodBeat.o(27652);
            }
        });
        a(qVar, es);
        AppMethodBeat.o(27690);
        return es;
    }

    public static o a(q qVar, String str, String str2, String str3, String str4, String str5, final com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
        AppMethodBeat.i(27691);
        final View ah = ah(qVar.ylL, R.layout.ps);
        final o es = es(ah);
        a(ah, aVar, es);
        if (bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
            AppMethodBeat.o(27691);
            return null;
        }
        a(ah, (int) R.id.b0f, str2, false, 0);
        NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) ah.findViewById(R.id.b0a);
        noMeasuredTextView.setShouldEllipsize(true);
        noMeasuredTextView.setTextSize(0, qVar.ylL.getResources().getDimension(R.dimen.dt) * com.tencent.mm.bz.a.dm(qVar.ylL));
        noMeasuredTextView.setTextColor(com.tencent.mm.bz.a.h(qVar.ylL, (int) R.color.w4));
        if (bo.isNullOrNil(str)) {
            noMeasuredTextView.setText(((com.tencent.mm.plugin.emoji.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.emoji.b.a.class)).b(qVar.ylL, str3, noMeasuredTextView.getTextSize()));
        } else {
            noMeasuredTextView.setText(((com.tencent.mm.plugin.emoji.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.emoji.b.a.class)).b(qVar.ylL, ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.a.b.class)).mJ(str), noMeasuredTextView.getTextSize()));
        }
        a(ah, (int) R.id.b0k, str4, true, 8);
        Button button = (Button) ah.findViewById(R.id.b03);
        if (!bo.isNullOrNil(str5)) {
            button.setText(str5);
        }
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27653);
                if (aVar != null) {
                    aVar.a(true, g.et(ah), g.eu(ah));
                }
                es.dismiss();
                es.setFocusable(false);
                es.setTouchable(false);
                AppMethodBeat.o(27653);
            }
        });
        if (!bo.isNullOrNil(str)) {
            com.tencent.mm.pluginsdk.ui.a.b.b((ImageView) ah.findViewById(R.id.b0_), str);
        }
        a(qVar, es);
        AppMethodBeat.o(27691);
        return es;
    }

    public static o a(q qVar, long j, String str, String str2, String str3, final com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
        AppMethodBeat.i(27692);
        final View ah = ah(qVar.ylL, R.layout.ps);
        final o es = es(ah);
        a(ah, aVar, es);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
            AppMethodBeat.o(27692);
            return null;
        }
        CharSequence charSequence;
        String str4;
        String str5;
        a(ah, (int) R.id.b0f, str, false, 0);
        NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) ah.findViewById(R.id.b0a);
        noMeasuredTextView.setShouldEllipsize(true);
        noMeasuredTextView.setTextSize(0, qVar.ylL.getResources().getDimension(R.dimen.dt) * com.tencent.mm.bz.a.dm(qVar.ylL));
        noMeasuredTextView.setTextColor(com.tencent.mm.bz.a.h(qVar.ylL, (int) R.color.w4));
        com.tencent.mm.aj.a.c aK = ((h) com.tencent.mm.kernel.g.K(h.class)).aK(j);
        if (aK == null || !aK.isGroup()) {
            com.tencent.mm.aj.a.j cH = ((i) com.tencent.mm.kernel.g.K(i.class)).cH(aK.field_bizChatServId);
            if (cH != null) {
                charSequence = cH.field_userName;
                str4 = cH.field_headImageUrl;
                str5 = cH.field_brandUserName;
            } else {
                ab.w("MicroMsg.MMConfirmDialog", "showDialogItem8 userInfo is null");
                AppMethodBeat.o(27692);
                return null;
            }
        }
        charSequence = aK.field_chatName;
        str4 = aK.field_headImageUrl;
        str5 = aK.field_brandUserName;
        if (charSequence == null) {
            charSequence = str2;
        }
        if (bo.isNullOrNil(charSequence)) {
            noMeasuredTextView.setText(j.b(qVar.ylL, (CharSequence) str2, noMeasuredTextView.getTextSize()));
        } else {
            noMeasuredTextView.setText(j.b(qVar.ylL, charSequence, noMeasuredTextView.getTextSize()));
        }
        a(ah, (int) R.id.b0k, null, true, 8);
        Button button = (Button) ah.findViewById(R.id.b03);
        if (!bo.isNullOrNil(str3)) {
            button.setText(str3);
        }
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(27654);
                if (aVar != null) {
                    aVar.a(true, g.et(ah), g.eu(ah));
                }
                es.dismiss();
                es.setFocusable(false);
                es.setTouchable(false);
                AppMethodBeat.o(27654);
            }
        });
        com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
        aVar2.ePK = com.tencent.mm.api.a.cC(str5);
        aVar2.ePH = true;
        aVar2.ePZ = true;
        aVar2.ePT = R.raw.default_avatar;
        com.tencent.mm.at.a.a.c ahG = aVar2.ahG();
        if (!bo.isNullOrNil(str4)) {
            com.tencent.mm.at.o.ahp().a(str4, (ImageView) ah.findViewById(R.id.b0_), ahG);
        }
        a(qVar, es);
        AppMethodBeat.o(27692);
        return es;
    }

    private static void a(q qVar, o oVar) {
        AppMethodBeat.i(27702);
        try {
            if (!qVar.ylL.isFinishing()) {
                oVar.setInputMethodMode(1);
                oVar.setSoftInputMode(16);
                oVar.setFocusable(true);
                oVar.setTouchable(true);
                oVar.showAtLocation(qVar.ylL.getWindow().getDecorView(), 17, 0, 0);
            }
            AppMethodBeat.o(27702);
        } catch (Exception e) {
            ab.e("MicroMsg.MMConfirmDialog", "show dialog fail: %s", e.getMessage());
            ab.printErrStackTrace("MicroMsg.MMConfirmDialog", e, "", new Object[0]);
            AppMethodBeat.o(27702);
        }
    }

    static /* synthetic */ void b(com.tencent.mm.ui.widget.a.c.a aVar, final Bitmap bitmap) {
        AppMethodBeat.i(27705);
        aVar.a(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(27648);
                if (bitmap == null || bitmap.isRecycled()) {
                    AppMethodBeat.o(27648);
                    return;
                }
                ab.i("MicroMsg.MMConfirmDialog", "bitmap recycle %s", bitmap.toString());
                bitmap.recycle();
                AppMethodBeat.o(27648);
            }
        });
        AppMethodBeat.o(27705);
    }

    static /* synthetic */ String et(View view) {
        AppMethodBeat.i(27709);
        EditText editText = (EditText) view.findViewById(R.id.b09);
        if (editText == null) {
            AppMethodBeat.o(27709);
            return null;
        }
        String obj = editText.getText().toString();
        AppMethodBeat.o(27709);
        return obj;
    }

    static /* synthetic */ int eu(View view) {
        AppMethodBeat.i(27710);
        EditText editText = (EditText) view.findViewById(R.id.b09);
        if (editText instanceof PasterEditText) {
            int pasterLen = ((PasterEditText) editText).getPasterLen();
            AppMethodBeat.o(27710);
            return pasterLen;
        }
        AppMethodBeat.o(27710);
        return 0;
    }
}
