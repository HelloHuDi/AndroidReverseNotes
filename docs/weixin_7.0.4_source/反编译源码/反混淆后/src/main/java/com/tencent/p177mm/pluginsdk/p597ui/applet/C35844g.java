package com.tencent.p177mm.pluginsdk.p597ui.applet;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C25781a;
import com.tencent.p177mm.api.C25782h;
import com.tencent.p177mm.api.C8954i;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p184aj.p185a.C45142c;
import com.tencent.p177mm.p184aj.p185a.C45143j;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5536q;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.p612ui.base.NoMeasuredTextView;
import com.tencent.p177mm.p612ui.p627e.p1575a.C46685a;
import com.tencent.p177mm.p612ui.widget.edittext.PasterEditText;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a.C5648a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a.C5649b;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a.C5650c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a.C5651d;
import com.tencent.p177mm.plugin.chatroom.p721a.C33811b;
import com.tencent.p177mm.plugin.emoji.p725b.C45845a;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C35852b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.util.C46823d;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.pluginsdk.ui.applet.g */
public final class C35844g implements C40463q {
    private static int[] vkg = new int[]{2131822940, 2131822941, 2131822942, 2131822943, 2131822944, 2131822945, 2131822946, 2131822947, 2131822948};

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.g$7 */
    static class C149237 implements C5648a {
        C149237() {
        }

        /* renamed from: u */
        public final void mo11442u(ImageView imageView, String str) {
            AppMethodBeat.m2504i(27645);
            C46685a.m88422b(imageView, str);
            AppMethodBeat.m2505o(27645);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.g$a */
    public static class C23273a {
        public C5653c gud;
        public OnDismissListener jbD;
        Context mContext;
        final C5652a vkm;
        String vkn = null;

        /* renamed from: com.tencent.mm.pluginsdk.ui.applet.g$a$1 */
        class C149241 implements C5651d {
            C149241() {
            }

            /* renamed from: a */
            public final CharSequence mo11445a(CharSequence charSequence, float f) {
                AppMethodBeat.m2504i(27656);
                SpannableString a = ((C45845a) C1720g.m3528K(C45845a.class)).mo68462a(C23273a.this.mContext, charSequence, f);
                AppMethodBeat.m2505o(27656);
                return a;
            }
        }

        public C23273a(Context context) {
            AppMethodBeat.m2504i(27657);
            this.mContext = context;
            this.vkm = new C5652a(this.mContext);
            this.vkm.mo11482rc(false);
            this.vkm.mo11483rd(false);
            this.vkm.mo11460a(new C149241());
            AppMethodBeat.m2505o(27657);
        }

        /* renamed from: cx */
        public final C23273a mo38972cx(Object obj) {
            AppMethodBeat.m2504i(27658);
            C35844g.m58790b(this.mContext, this.vkm, obj);
            this.vkm.mo11480ra(true);
            AppMethodBeat.m2505o(27658);
            return this;
        }

        public final C23273a djw() {
            AppMethodBeat.m2504i(27659);
            this.vkm.mo11451Qa(2);
            AppMethodBeat.m2505o(27659);
            return this;
        }

        public final C23273a ajC(String str) {
            AppMethodBeat.m2504i(27660);
            int fromDPToPix = C1338a.fromDPToPix(this.mContext, (int) (14.0f * C1338a.m2860dm(this.mContext)));
            if (!C5046bo.isNullOrNil(str)) {
                this.vkm.mo11466ak(((C45845a) C1720g.m3528K(C45845a.class)).mo68462a(this.mContext, str.toString(), (float) fromDPToPix));
            }
            AppMethodBeat.m2505o(27660);
            return this;
        }

        public final C23273a ajD(String str) {
            AppMethodBeat.m2504i(27661);
            this.vkm.asF(str);
            AppMethodBeat.m2505o(27661);
            return this;
        }

        public final C23273a djx() {
            this.vkm.zQe.zPy = 8;
            return this;
        }

        /* renamed from: b */
        public final C23273a mo38971b(Bitmap bitmap, int i) {
            AppMethodBeat.m2504i(27662);
            this.vkm.mo11459a(bitmap, true, i);
            this.vkm.mo11480ra(false);
            C35844g.m58791b(this.vkm, bitmap);
            AppMethodBeat.m2505o(27662);
            return this;
        }

        public final C23273a ajE(String str) {
            AppMethodBeat.m2504i(27663);
            C35844g.m58775a(this.mContext, this.vkm, str);
            this.vkm.mo11480ra(false);
            AppMethodBeat.m2505o(27663);
            return this;
        }

        /* renamed from: a */
        public final C23273a mo38967a(C5649b c5649b) {
            AppMethodBeat.m2504i(27664);
            this.vkm.mo11477b(c5649b);
            AppMethodBeat.m2505o(27664);
            return this;
        }

        /* renamed from: ev */
        public final C23273a mo38976ev(View view) {
            AppMethodBeat.m2504i(27665);
            this.vkm.mo11479fn(view);
            AppMethodBeat.m2505o(27665);
            return this;
        }

        /* renamed from: h */
        public final C23273a mo38977h(Boolean bool) {
            AppMethodBeat.m2504i(27666);
            this.vkm.mo11481rb(bool.booleanValue());
            if (bool.booleanValue()) {
                this.vkm.asH(this.mContext.getString(C25738R.string.atc));
            }
            AppMethodBeat.m2505o(27666);
            return this;
        }

        public final C23273a djy() {
            AppMethodBeat.m2504i(27667);
            this.vkm.mo11480ra(false);
            AppMethodBeat.m2505o(27667);
            return this;
        }

        /* renamed from: KQ */
        public final C23273a mo38965KQ(int i) {
            AppMethodBeat.m2504i(27668);
            this.vkn = this.mContext.getResources().getString(i);
            AppMethodBeat.m2505o(27668);
            return this;
        }

        /* renamed from: a */
        public final C23273a mo38966a(C30111a c30111a) {
            AppMethodBeat.m2504i(27669);
            this.gud = this.vkm.aMb();
            if (this.jbD != null) {
                this.gud.setOnDismissListener(this.jbD);
            }
            C35844g.m58776a(this.mContext, this.gud, this.vkn, c30111a, c30111a);
            AppMethodBeat.m2505o(27669);
            return this;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.g$11 */
    static class C3010111 implements C5648a {
        C3010111() {
        }

        /* renamed from: u */
        public final void mo11442u(ImageView imageView, String str) {
            AppMethodBeat.m2504i(27649);
            C46685a.m88422b(imageView, str);
            AppMethodBeat.m2505o(27649);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m58790b(Context context, C5652a c5652a, Object obj) {
        AppMethodBeat.m2504i(27704);
        C35844g.m58774a(context, c5652a, obj);
        AppMethodBeat.m2505o(27704);
    }

    /* renamed from: a */
    private static void m58774a(Context context, C5652a c5652a, Object obj) {
        AppMethodBeat.m2504i(27670);
        if (obj != null) {
            List P;
            if (obj instanceof String) {
                P = C5046bo.m7508P(((String) obj).split(","));
            } else if (obj instanceof List) {
                P = (List) obj;
            } else {
                P = null;
            }
            if (C5046bo.m7548ek(P)) {
                AppMethodBeat.m2505o(27670);
                return;
            } else if (P.size() == 1) {
                final String str = (String) P.get(0);
                int fromDPToPix = C1338a.fromDPToPix(context, (int) (20.0f * C1338a.m2860dm(context)));
                c5652a.mo11464ai(((C45845a) C1720g.m3528K(C45845a.class)).mo68462a(context, context.getString(C25738R.string.dr6).toString(), (float) fromDPToPix)).mo11449PY(3);
                String mJ = ((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(str);
                int fromDPToPix2 = C1338a.fromDPToPix(context, (int) (14.0f * C1338a.m2860dm(context)));
                if (C1855t.m3896kH(str)) {
                    SpannableString a = ((C45845a) C1720g.m3528K(C45845a.class)).mo68462a(context, (mJ + context.getString(C25738R.string.e1l, new Object[]{Integer.valueOf(((C33811b) C1720g.m3528K(C33811b.class)).mo54368mA(str))})).toString(), (float) fromDPToPix2);
                    final View inflate = C5616v.m8409hu(context).inflate(2130969289, null);
                    GridView gridView = (GridView) inflate.findViewById(2131823307);
                    final ArrayList arrayList = new ArrayList();
                    final List my = ((C33811b) C1720g.m3528K(C33811b.class)).mo54369my(str);
                    c5652a.mo11461a(str, a, Boolean.TRUE, new C5650c() {
                        public final void djv() {
                            AppMethodBeat.m2504i(27639);
                            C5046bo.hideVKB(inflate);
                            if (arrayList.size() == 0 && !C5046bo.isNullOrNil(str)) {
                                C35844g.m58785a(arrayList, my);
                            }
                            AppMethodBeat.m2505o(27639);
                        }
                    }, new C149237());
                    gridView.setAdapter(new C14930l(context, my, arrayList));
                    gridView.setSelector(new ColorDrawable(context.getResources().getColor(C25738R.color.a3p)));
                    if (my != null) {
                        if (my.size() > 16) {
                            gridView.setLayoutParams(new LayoutParams(-1, C1338a.m2856al(context, C25738R.dimen.f9791fq)));
                            gridView.setPadding(C1338a.m2856al(context, C25738R.dimen.f9787fm), 0, C1338a.m2856al(context, C25738R.dimen.f9787fm), 0);
                        } else {
                            gridView.setPadding(0, 0, 0, C1338a.m2856al(context, C25738R.dimen.f9784fj));
                        }
                    }
                    c5652a.zQe.zPt = inflate;
                    AppMethodBeat.m2505o(27670);
                    return;
                }
                c5652a.mo11461a(str, ((C45845a) C1720g.m3528K(C45845a.class)).mo68462a(context, mJ.toString(), (float) fromDPToPix2), Boolean.FALSE, null, new C3010111());
                AppMethodBeat.m2505o(27670);
                return;
            } else {
                c5652a.zQe.zPs = C35844g.m58792d(context, P);
                c5652a.asD(context.getString(C25738R.string.d1w)).mo11449PY(3);
            }
        }
        AppMethodBeat.m2505o(27670);
    }

    /* renamed from: d */
    private static View m58792d(Context context, List<String> list) {
        AppMethodBeat.m2504i(27671);
        View inflate = View.inflate(context, 2130969191, null);
        if (list != null) {
            int i = 0;
            for (String str : list) {
                if (i <= 8 && inflate != null) {
                    ImageView imageView = (ImageView) inflate.findViewById(vkg[i]);
                    if (str != null) {
                        imageView.setVisibility(0);
                        C46685a.m88422b(imageView, str);
                        i++;
                    }
                }
                i = i;
            }
        }
        AppMethodBeat.m2505o(27671);
        return inflate;
    }

    /* renamed from: a */
    private static void m58777a(Context context, final C5653c c5653c, String str, String str2, final C30111a c30111a, final C30111a c30111a2) {
        CharSequence str3;
        CharSequence str22;
        String str4 = null;
        AppMethodBeat.m2504i(27672);
        if (C5046bo.isNullOrNil(str3) || str3.length() == 0) {
            str3 = context.getResources().getString(C25738R.string.atf);
        }
        if (C5046bo.isNullOrNil(str4) || str4.length() == 0) {
            str22 = context.getResources().getString(C25738R.string.f9076or);
        }
        c5653c.mo11489a(str3, true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(27650);
                c5653c.dismiss();
                if (c30111a != null) {
                    c30111a.mo6399a(true, c5653c.dKV(), c5653c.dKW());
                }
                AppMethodBeat.m2505o(27650);
            }
        });
        c5653c.mo11491b(str22, true, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(27651);
                c5653c.dismiss();
                if (c30111a2 != null) {
                    c30111a2.mo6399a(false, null, 0);
                }
                AppMethodBeat.m2505o(27651);
            }
        });
        AppMethodBeat.m2505o(27672);
    }

    /* renamed from: a */
    public static C5653c m58765a(C5536q c5536q, String str, String str2, String str3, boolean z, String str4, C30111a c30111a) {
        AppMethodBeat.m2504i(27673);
        if ((str == null || str.length() == 0) && (str3 == null || str3.length() == 0)) {
            C4990ab.m7412e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            AppMethodBeat.m2505o(27673);
            return null;
        }
        View inflate = View.inflate(c5536q.ylL, 2130969184, null);
        C5652a c5652a = new C5652a(c5536q.ylL);
        c5652a.mo11482rc(false);
        c5652a.mo11483rd(false);
        C35844g.m58783a(c5652a, c5536q.ylL, str);
        C35844g.m58796u(inflate, z);
        C35844g.m58781a(c5536q, c5652a, c30111a, inflate, str4);
        TextView textView = (TextView) inflate.findViewById(2131822923);
        textView.setText(C44089j.m79293b(c5536q.ylL, (CharSequence) str3, textView.getTextSize()));
        inflate.findViewById(2131822924).setVisibility(8);
        int b = C4977b.m7371b(c5536q.ylL, 120.0f);
        CdnImageView cdnImageView = (CdnImageView) inflate.findViewById(2131822922);
        if (cdnImageView != null) {
            cdnImageView.mo11120am(str2, b, b);
        }
        c5652a.mo11479fn(inflate);
        C5653c aMb = c5652a.aMb();
        aMb.show();
        AppMethodBeat.m2505o(27673);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m58767a(C5536q c5536q, String str, String str2, boolean z, String str3, C30111a c30111a, String str4) {
        AppMethodBeat.m2504i(27675);
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            C4990ab.m7412e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            AppMethodBeat.m2505o(27675);
            return null;
        }
        C5652a c5652a = new C5652a(c5536q.ylL);
        String string = c5536q.ylL.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            C35844g.m58774a(c5536q.ylL, c5652a, C5046bo.m7508P(string.split(",")));
        }
        c5652a.mo11480ra(true);
        c5652a.mo11466ak(str).mo11482rc(false).mo11483rd(false);
        if (z) {
            c5652a.mo11481rb(true);
        }
        C5653c aMb = c5652a.aMb();
        C35844g.m58777a(c5536q.ylL, aMb, str3, null, c30111a, c30111a);
        aMb.show();
        AppMethodBeat.m2505o(27675);
        return aMb;
    }

    /* renamed from: b */
    public static C5653c m58787b(C5536q c5536q, String str, String str2, String str3, String str4, String str5, C30111a c30111a) {
        AppMethodBeat.m2504i(27676);
        if ((str == null || str.length() == 0) && (str3 == null || str3.length() == 0)) {
            C4990ab.m7412e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            AppMethodBeat.m2505o(27676);
            return null;
        }
        View inflate = View.inflate(c5536q.ylL, 2130969184, null);
        C5652a c5652a = new C5652a(c5536q.ylL);
        c5652a.mo11482rc(false);
        c5652a.mo11483rd(false);
        C35844g.m58783a(c5652a, c5536q.ylL, str);
        if (inflate != null) {
            EditText editText = (EditText) inflate.findViewById(2131822921);
            if (editText != null) {
                editText.setVisibility(0);
            }
            editText.setText(str4);
        }
        C35844g.m58781a(c5536q, c5652a, c30111a, inflate, str5);
        TextView textView = (TextView) inflate.findViewById(2131822923);
        textView.setText(C44089j.m79293b(c5536q.ylL, (CharSequence) str3, textView.getTextSize()));
        inflate.findViewById(2131822924).setVisibility(8);
        int b = C4977b.m7371b(c5536q.ylL, 120.0f);
        CdnImageView cdnImageView = (CdnImageView) inflate.findViewById(2131822922);
        if (cdnImageView != null) {
            cdnImageView.mo11120am(str2, b, b);
        }
        c5652a.mo11479fn(inflate);
        C5653c aMb = c5652a.aMb();
        aMb.show();
        AppMethodBeat.m2505o(27676);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m58764a(C5536q c5536q, String str, String str2, C30111a c30111a) {
        AppMethodBeat.m2504i(27677);
        C5653c a = C35844g.m58766a(c5536q, str, str2, false, "", c30111a);
        AppMethodBeat.m2505o(27677);
        return a;
    }

    /* renamed from: a */
    public static C5653c m58770a(C5536q c5536q, String str, boolean z, C30111a c30111a) {
        AppMethodBeat.m2504i(27678);
        C5653c a = C35844g.m58771a(c5536q, str, z, "", c30111a);
        AppMethodBeat.m2505o(27678);
        return a;
    }

    /* renamed from: a */
    public static C5653c m58771a(C5536q c5536q, String str, boolean z, String str2, C30111a c30111a) {
        AppMethodBeat.m2504i(27679);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.MMConfirmDialog", "showDialogItem2 fail, message is empty");
            AppMethodBeat.m2505o(27679);
            return null;
        }
        C5652a c5652a = new C5652a(c5536q.ylL);
        String string = c5536q.ylL.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            C35844g.m58774a(c5536q.ylL, c5652a, C5046bo.m7508P(string.split(",")));
        }
        c5652a.mo11480ra(true);
        c5652a.mo11466ak(str).mo11482rc(false).mo11483rd(false);
        if (z) {
            c5652a.mo11481rb(true);
        }
        C5653c aMb = c5652a.aMb();
        C35844g.m58777a(c5536q.ylL, aMb, str2, null, c30111a, c30111a);
        aMb.show();
        AppMethodBeat.m2505o(27679);
        return aMb;
    }

    /* renamed from: b */
    public static C5653c m58788b(C5536q c5536q, String str, boolean z, C30111a c30111a) {
        AppMethodBeat.m2504i(27680);
        C5653c b = C35844g.m58789b(c5536q, str, z, "", c30111a);
        AppMethodBeat.m2505o(27680);
        return b;
    }

    /* renamed from: b */
    public static C5653c m58789b(C5536q c5536q, String str, boolean z, String str2, C30111a c30111a) {
        AppMethodBeat.m2504i(27681);
        if (str == null || !C1173e.m2561ct(str)) {
            C4990ab.m7412e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, img does not exist");
            AppMethodBeat.m2505o(27681);
            return null;
        }
        C5652a c5652a = new C5652a(c5536q.ylL);
        String string = c5536q.ylL.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            C35844g.m58774a(c5536q.ylL, c5652a, C5046bo.m7508P(string.split(",")));
        }
        c5652a.mo11480ra(true);
        c5652a.mo11482rc(false).mo11483rd(false);
        if (z) {
            c5652a.mo11481rb(true);
        }
        if (!C5046bo.isNullOrNil(str)) {
            Bitmap aml = C5056d.aml(str);
            int bJ = ExifHelper.m7368bJ(str);
            if (aml != null) {
                if (bJ != 0) {
                    aml = C5056d.m7648b(aml, (float) bJ);
                }
                c5652a.mo11459a(aml, true, 3);
                C35844g.m58784a(c5652a, aml);
                c5652a.mo11480ra(false);
            }
        }
        C5653c aMb = c5652a.aMb();
        C35844g.m58777a(c5536q.ylL, aMb, str2, null, c30111a, c30111a);
        aMb.show();
        AppMethodBeat.m2505o(27681);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m58772a(C5536q c5536q, byte[] bArr, boolean z, C30111a c30111a) {
        AppMethodBeat.m2504i(27682);
        C5653c a = C35844g.m58773a(c5536q, bArr, z, "", c30111a);
        AppMethodBeat.m2505o(27682);
        return a;
    }

    /* renamed from: a */
    public static C5653c m58773a(C5536q c5536q, byte[] bArr, boolean z, String str, C30111a c30111a) {
        AppMethodBeat.m2504i(27683);
        if (bArr == null || bArr.length == 0) {
            C4990ab.m7412e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, imgData is null");
            AppMethodBeat.m2505o(27683);
            return null;
        }
        C5652a c5652a = new C5652a(c5536q.ylL);
        String string = c5536q.ylL.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            C35844g.m58774a(c5536q.ylL, c5652a, C5046bo.m7508P(string.split(",")));
        }
        c5652a.mo11480ra(true);
        c5652a.mo11482rc(false).mo11483rd(false);
        if (z) {
            c5652a.mo11481rb(true);
        }
        if (bArr != null && bArr.length > 0) {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            int cs = C46823d.m89056cs(bArr);
            if (decodeByteArray != null) {
                if (cs != 0) {
                    decodeByteArray = C5056d.m7648b(decodeByteArray, (float) cs);
                }
                c5652a.mo11459a(decodeByteArray, true, 3);
                C35844g.m58784a(c5652a, decodeByteArray);
                c5652a.mo11480ra(false);
            }
        }
        C5653c aMb = c5652a.aMb();
        C35844g.m58777a(c5536q.ylL, aMb, str, null, c30111a, c30111a);
        aMb.show();
        AppMethodBeat.m2505o(27683);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m58759a(C5536q c5536q, int i, String str, boolean z, C30111a c30111a) {
        AppMethodBeat.m2504i(27684);
        C5653c a = C35844g.m58760a(c5536q, i, str, z, "", c30111a);
        AppMethodBeat.m2505o(27684);
        return a;
    }

    /* renamed from: a */
    public static C5653c m58760a(C5536q c5536q, int i, String str, boolean z, String str2, C30111a c30111a) {
        AppMethodBeat.m2504i(27685);
        C5652a c5652a = new C5652a(c5536q.ylL);
        String string = c5536q.ylL.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            C35844g.m58774a(c5536q.ylL, c5652a, C5046bo.m7508P(string.split(",")));
        }
        c5652a.mo11480ra(true);
        if (i == C1318a.app_attach_file_icon_file) {
            string = c5536q.ylL.getResources().getString(C25738R.string.f9140qr);
        } else if (i == C1318a.app_attach_file_icon_music) {
            string = c5536q.ylL.getResources().getString(C25738R.string.f9174rs);
        } else if (i == C1318a.app_attach_file_icon_video) {
            string = c5536q.ylL.getResources().getString(C25738R.string.f9253ud);
        } else {
            string = c5536q.ylL.getResources().getString(C25738R.string.f8820fy);
        }
        c5652a.mo11466ak(str).mo11482rc(false).mo11483rd(false);
        if (z) {
            c5652a.mo11481rb(true);
        }
        C5653c aMb = c5652a.aMb();
        C35844g.m58777a(c5536q.ylL, aMb, str2, null, c30111a, c30111a);
        aMb.show();
        AppMethodBeat.m2505o(27685);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m58768a(C5536q c5536q, String str, boolean z, int i, C30111a c30111a) {
        AppMethodBeat.m2504i(27686);
        C5653c a = C35844g.m58769a(c5536q, str, z, i, "", c30111a);
        AppMethodBeat.m2505o(27686);
        return a;
    }

    /* renamed from: a */
    public static C5653c m58769a(C5536q c5536q, String str, boolean z, int i, String str2, C30111a c30111a) {
        Object P;
        AppMethodBeat.m2504i(27687);
        C5652a c5652a = new C5652a(c5536q.ylL);
        String string = c5536q.ylL.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            P = C5046bo.m7508P(string.split(","));
        } else {
            P = null;
        }
        C35844g.m58774a(c5536q.ylL, c5652a, P);
        c5652a.mo11480ra(true);
        switch (i) {
            case 1:
                string = c5536q.ylL.getResources().getString(C25738R.string.f9253ud);
                break;
            case 2:
                string = c5536q.ylL.getResources().getString(C25738R.string.f9174rs);
                break;
            default:
                string = c5536q.ylL.getResources().getString(C25738R.string.f8820fy);
                break;
        }
        c5652a.mo11466ak(new StringBuffer(string).append(str).toString()).mo11482rc(false).mo11483rd(false);
        if (z) {
            c5652a.mo11481rb(true);
        }
        C5653c aMb = c5652a.aMb();
        C35844g.m58777a(c5536q.ylL, aMb, str2, null, c30111a, c30111a);
        aMb.show();
        AppMethodBeat.m2505o(27687);
        return aMb;
    }

    /* renamed from: a */
    public static C5653c m58762a(C5536q c5536q, String str, Bitmap bitmap, String str2, String str3, C30111a c30111a) {
        AppMethodBeat.m2504i(27689);
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            C4990ab.m7412e("MicroMsg.MMConfirmDialog", "showDialogItem6 fail, title message both are empty");
            AppMethodBeat.m2505o(27689);
            return null;
        }
        View ah = C35844g.m58786ah(c5536q.ylL, 2130969186);
        C5652a c5652a = new C5652a(c5536q.ylL);
        c5652a.mo11482rc(false);
        c5652a.mo11483rd(false);
        C35844g.m58796u(ah, false);
        C35844g.m58781a(c5536q, c5652a, c30111a, ah, c5536q.ylL.getResources().getString(C25738R.string.au4));
        TextView textView = (TextView) ah.findViewById(2131822928);
        textView.setText(C44089j.m79293b(c5536q.ylL, (CharSequence) str, textView.getTextSize()));
        textView = (TextView) ah.findViewById(2131822923);
        textView.setText(C44089j.m79293b(c5536q.ylL, (CharSequence) str2, textView.getTextSize()));
        if (str3.length() == 0) {
            ah.findViewById(2131822924).setVisibility(8);
        } else {
            ((TextView) ah.findViewById(2131822924)).setText(str3);
        }
        ImageView imageView = (ImageView) ah.findViewById(2131822922);
        if (imageView != null) {
            if (bitmap == null || bitmap.isRecycled()) {
                imageView.setVisibility(4);
            } else {
                imageView.setImageBitmap(bitmap);
                C35844g.m58784a(c5652a, bitmap);
            }
        }
        c5652a.mo11479fn(ah);
        C5653c aMb = c5652a.aMb();
        aMb.show();
        AppMethodBeat.m2505o(27689);
        return aMb;
    }

    /* renamed from: a */
    public static void m58782a(C5536q c5536q, String str, String str2, String str3, C30111a c30111a) {
        AppMethodBeat.m2504i(27693);
        C23273a h = new C23273a(c5536q.ylL).mo38972cx(str).ajC(str2).mo38977h(Boolean.FALSE);
        h.vkn = str3;
        h.mo38966a(c30111a).gud.show();
        AppMethodBeat.m2505o(27693);
    }

    /* renamed from: a */
    public static C5653c m58763a(C5536q c5536q, String str, View view, String str2, final C35852b c35852b) {
        AppMethodBeat.m2504i(27694);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            AppMethodBeat.m2505o(27694);
            return null;
        }
        C5652a c5652a = new C5652a(c5536q.ylL);
        c5652a.mo11482rc(false);
        c5652a.mo11483rd(false);
        C35844g.m58783a(c5652a, c5536q.ylL, str);
        if (C5046bo.isNullOrNil(str2) || str2.length() == 0) {
            str2 = c5536q.ylL.getResources().getString(C25738R.string.atf);
        }
        c5652a.asJ(str2).mo11457a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(27641);
                if (c35852b != null) {
                    c35852b.mo26134iw(true);
                }
                AppMethodBeat.m2505o(27641);
            }
        });
        c5652a.mo11454Qd(C25738R.string.f9076or).mo11476b(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(27642);
                if (c35852b != null) {
                    c35852b.mo26134iw(false);
                }
                AppMethodBeat.m2505o(27642);
            }
        });
        c5652a.mo11479fn(view);
        C5653c aMb = c5652a.aMb();
        aMb.mo11485PT(c5536q.ylL.getResources().getColor(C25738R.color.f11795hi));
        aMb.show();
        AppMethodBeat.m2505o(27694);
        return aMb;
    }

    /* renamed from: ah */
    private static View m58786ah(Context context, int i) {
        AppMethodBeat.m2504i(27695);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, null);
        AppMethodBeat.m2505o(27695);
        return inflate;
    }

    /* renamed from: es */
    private static C46633o m58793es(View view) {
        AppMethodBeat.m2504i(27696);
        C46633o c46633o = new C46633o(view, -1, -1);
        AppMethodBeat.m2505o(27696);
        return c46633o;
    }

    /* renamed from: a */
    private static void m58781a(C5536q c5536q, C5652a c5652a, final C30111a c30111a, final View view, String str) {
        AppMethodBeat.m2504i(27697);
        if (C5046bo.isNullOrNil(str) || str.length() == 0) {
            str = c5536q.ylL.getResources().getString(C25738R.string.atf);
        }
        c5652a.asJ(str).mo11457a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(27655);
                if (c30111a != null) {
                    c30111a.mo6399a(true, C35844g.m58794et(view), C35844g.m58795eu(view));
                }
                AppMethodBeat.m2505o(27655);
            }
        });
        c5652a.mo11454Qd(C25738R.string.f9076or).mo11476b(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(27640);
                if (c30111a != null) {
                    c30111a.mo6399a(false, null, 0);
                }
                AppMethodBeat.m2505o(27640);
            }
        });
        AppMethodBeat.m2505o(27697);
    }

    /* renamed from: a */
    private static void m58783a(C5652a c5652a, Context context, String str) {
        AppMethodBeat.m2504i(27698);
        c5652a.asD(str);
        c5652a.mo11447PW(context.getResources().getColor(C25738R.color.f12212w4));
        c5652a.mo11448PX(2);
        AppMethodBeat.m2505o(27698);
    }

    /* renamed from: a */
    private static void m58779a(final View view, final C30111a c30111a, final C46633o c46633o) {
        AppMethodBeat.m2504i(27699);
        ((Button) view.findViewById(2131822915)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(27643);
                if (c30111a != null) {
                    c30111a.mo6399a(true, C35844g.m58794et(view), C35844g.m58795eu(view));
                }
                c46633o.dismiss();
                c46633o.setFocusable(false);
                c46633o.setTouchable(false);
                AppMethodBeat.m2505o(27643);
            }
        });
        Button button = (Button) view.findViewById(2131822914);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(27644);
                    if (c30111a != null) {
                        c30111a.mo6399a(false, null, 0);
                    }
                    c46633o.dismiss();
                    c46633o.setFocusable(false);
                    c46633o.setTouchable(false);
                    AppMethodBeat.m2505o(27644);
                }
            });
        }
        AppMethodBeat.m2505o(27699);
    }

    /* renamed from: u */
    private static void m58796u(View view, boolean z) {
        AppMethodBeat.m2504i(27700);
        if (view != null) {
            EditText editText = (EditText) view.findViewById(2131822921);
            if (editText != null) {
                editText.setVisibility(z ? 0 : 8);
            }
        }
        AppMethodBeat.m2505o(27700);
    }

    /* renamed from: a */
    private static void m58778a(View view, int i, String str, boolean z, int i2) {
        AppMethodBeat.m2504i(27701);
        TextView textView = (TextView) view.findViewById(i);
        Assert.assertTrue(textView != null);
        if (z && C5046bo.isNullOrNil(str)) {
            textView.setVisibility(i2);
            AppMethodBeat.m2505o(27701);
            return;
        }
        textView.setText(str);
        AppMethodBeat.m2505o(27701);
    }

    /* renamed from: a */
    private static void m58784a(C5652a c5652a, final Bitmap bitmap) {
        AppMethodBeat.m2504i(27703);
        c5652a.mo11458a(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(27647);
                if (bitmap == null || bitmap.isRecycled()) {
                    AppMethodBeat.m2505o(27647);
                } else {
                    AppMethodBeat.m2505o(27647);
                }
            }
        });
        AppMethodBeat.m2505o(27703);
    }

    /* renamed from: a */
    public static C5653c m58766a(C5536q c5536q, String str, String str2, boolean z, String str3, C30111a c30111a) {
        AppMethodBeat.m2504i(27674);
        C5653c a = C35844g.m58767a(c5536q, str, str2, z, str3, c30111a, c5536q.ylL.getResources().getString(C25738R.string.f9248u9));
        AppMethodBeat.m2505o(27674);
        return a;
    }

    /* renamed from: a */
    public static C5653c m58761a(C5536q c5536q, Bitmap bitmap, String str, String str2, String str3, C30111a c30111a) {
        AppMethodBeat.m2504i(27688);
        View ah = C35844g.m58786ah(c5536q.ylL, 2130969185);
        C5652a c5652a = new C5652a(c5536q.ylL);
        c5652a.mo11482rc(false);
        c5652a.mo11483rd(false);
        C35844g.m58796u(ah, true);
        C35844g.m58781a(c5536q, c5652a, c30111a, ah, c5536q.ylL.getResources().getString(C25738R.string.atf));
        TextView textView = (TextView) ah.findViewById(2131822928);
        textView.setText(C44089j.m79293b(c5536q.ylL, (CharSequence) str, textView.getTextSize()));
        textView = (TextView) ah.findViewById(2131822923);
        textView.setText(C44089j.m79293b(c5536q.ylL, (CharSequence) str2, textView.getTextSize()));
        textView = (TextView) ah.findViewById(2131822924);
        if (str3 == null || str3.length() == 0) {
            textView.setVisibility(8);
        } else {
            textView.setText(str3);
            textView.setVisibility(0);
        }
        ImageView imageView = (ImageView) ah.findViewById(2131822922);
        if (imageView != null) {
            if (bitmap == null || bitmap.isRecycled()) {
                C4990ab.m7420w("MicroMsg.MMConfirmDialog", "showDialogItem4, thumbBmp is null or recycled");
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap);
                C35844g.m58784a(c5652a, bitmap);
            }
        }
        c5652a.mo11479fn(ah);
        C5653c aMb = c5652a.aMb();
        aMb.show();
        AppMethodBeat.m2505o(27688);
        return aMb;
    }

    /* renamed from: a */
    public static C46633o m58757a(C5536q c5536q, final Bitmap bitmap, String str, final C30111a c30111a) {
        AppMethodBeat.m2504i(27690);
        final View ah = C35844g.m58786ah(c5536q.ylL, 2130969187);
        final C46633o es = C35844g.m58793es(ah);
        C35844g.m58779a(ah, c30111a, es);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.MMConfirmDialog", "showDialogItem7 fail, message is empty");
            AppMethodBeat.m2505o(27690);
            return null;
        }
        TextView textView = (TextView) ah.findViewById(2131822923);
        textView.setText(C44089j.m79293b(c5536q.ylL, (CharSequence) str, textView.getTextSize()));
        Button button = (Button) ah.findViewById(2131822915);
        ImageView imageView = (ImageView) ah.findViewById(2131822922);
        if (imageView != null) {
            if (bitmap == null || bitmap.isRecycled()) {
                imageView.setVisibility(8);
            } else {
                imageView.setImageBitmap(bitmap);
                es.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    public final void onDismiss() {
                        AppMethodBeat.m2504i(27646);
                        if (bitmap == null || bitmap.isRecycled()) {
                            AppMethodBeat.m2505o(27646);
                        } else {
                            AppMethodBeat.m2505o(27646);
                        }
                    }
                });
            }
        }
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(27652);
                if (c30111a != null) {
                    c30111a.mo6399a(true, C35844g.m58794et(ah), C35844g.m58795eu(ah));
                }
                es.dismiss();
                es.setFocusable(false);
                es.setTouchable(false);
                AppMethodBeat.m2505o(27652);
            }
        });
        C35844g.m58780a(c5536q, es);
        AppMethodBeat.m2505o(27690);
        return es;
    }

    /* renamed from: a */
    public static C46633o m58758a(C5536q c5536q, String str, String str2, String str3, String str4, String str5, final C30111a c30111a) {
        AppMethodBeat.m2504i(27691);
        final View ah = C35844g.m58786ah(c5536q.ylL, 2130969188);
        final C46633o es = C35844g.m58793es(ah);
        C35844g.m58779a(ah, c30111a, es);
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7412e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
            AppMethodBeat.m2505o(27691);
            return null;
        }
        C35844g.m58778a(ah, 2131822928, str2, false, 0);
        NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) ah.findViewById(2131822923);
        noMeasuredTextView.setShouldEllipsize(true);
        noMeasuredTextView.setTextSize(0, c5536q.ylL.getResources().getDimension(C25738R.dimen.f9728dt) * C1338a.m2860dm(c5536q.ylL));
        noMeasuredTextView.setTextColor(C1338a.m2870h(c5536q.ylL, (int) C25738R.color.f12212w4));
        if (C5046bo.isNullOrNil(str)) {
            noMeasuredTextView.setText(((C45845a) C1720g.m3528K(C45845a.class)).mo68463b(c5536q.ylL, str3, noMeasuredTextView.getTextSize()));
        } else {
            noMeasuredTextView.setText(((C45845a) C1720g.m3528K(C45845a.class)).mo68463b(c5536q.ylL, ((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(str), noMeasuredTextView.getTextSize()));
        }
        C35844g.m58778a(ah, 2131822933, str4, true, 8);
        Button button = (Button) ah.findViewById(2131822915);
        if (!C5046bo.isNullOrNil(str5)) {
            button.setText(str5);
        }
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(27653);
                if (c30111a != null) {
                    c30111a.mo6399a(true, C35844g.m58794et(ah), C35844g.m58795eu(ah));
                }
                es.dismiss();
                es.setFocusable(false);
                es.setTouchable(false);
                AppMethodBeat.m2505o(27653);
            }
        });
        if (!C5046bo.isNullOrNil(str)) {
            C40460b.m69434b((ImageView) ah.findViewById(2131822922), str);
        }
        C35844g.m58780a(c5536q, es);
        AppMethodBeat.m2505o(27691);
        return es;
    }

    /* renamed from: a */
    public static C46633o m58756a(C5536q c5536q, long j, String str, String str2, String str3, final C30111a c30111a) {
        AppMethodBeat.m2504i(27692);
        final View ah = C35844g.m58786ah(c5536q.ylL, 2130969188);
        final C46633o es = C35844g.m58793es(ah);
        C35844g.m58779a(ah, c30111a, es);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
            AppMethodBeat.m2505o(27692);
            return null;
        }
        CharSequence charSequence;
        String str4;
        String str5;
        C35844g.m58778a(ah, 2131822928, str, false, 0);
        NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) ah.findViewById(2131822923);
        noMeasuredTextView.setShouldEllipsize(true);
        noMeasuredTextView.setTextSize(0, c5536q.ylL.getResources().getDimension(C25738R.dimen.f9728dt) * C1338a.m2860dm(c5536q.ylL));
        noMeasuredTextView.setTextColor(C1338a.m2870h(c5536q.ylL, (int) C25738R.color.f12212w4));
        C45142c aK = ((C25782h) C1720g.m3528K(C25782h.class)).mo43744aK(j);
        if (aK == null || !aK.isGroup()) {
            C45143j cH = ((C8954i) C1720g.m3528K(C8954i.class)).mo20408cH(aK.field_bizChatServId);
            if (cH != null) {
                charSequence = cH.field_userName;
                str4 = cH.field_headImageUrl;
                str5 = cH.field_brandUserName;
            } else {
                C4990ab.m7420w("MicroMsg.MMConfirmDialog", "showDialogItem8 userInfo is null");
                AppMethodBeat.m2505o(27692);
                return null;
            }
        }
        charSequence = aK.field_chatName;
        str4 = aK.field_headImageUrl;
        str5 = aK.field_brandUserName;
        if (charSequence == null) {
            charSequence = str2;
        }
        if (C5046bo.isNullOrNil(charSequence)) {
            noMeasuredTextView.setText(C44089j.m79293b(c5536q.ylL, (CharSequence) str2, noMeasuredTextView.getTextSize()));
        } else {
            noMeasuredTextView.setText(C44089j.m79293b(c5536q.ylL, charSequence, noMeasuredTextView.getTextSize()));
        }
        C35844g.m58778a(ah, 2131822933, null, true, 8);
        Button button = (Button) ah.findViewById(2131822915);
        if (!C5046bo.isNullOrNil(str3)) {
            button.setText(str3);
        }
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(27654);
                if (c30111a != null) {
                    c30111a.mo6399a(true, C35844g.m58794et(ah), C35844g.m58795eu(ah));
                }
                es.dismiss();
                es.setFocusable(false);
                es.setTouchable(false);
                AppMethodBeat.m2505o(27654);
            }
        });
        C17927a c17927a = new C17927a();
        c17927a.ePK = C25781a.m40991cC(str5);
        c17927a.ePH = true;
        c17927a.ePZ = true;
        c17927a.ePT = C1318a.default_avatar;
        C25814c ahG = c17927a.ahG();
        if (!C5046bo.isNullOrNil(str4)) {
            C32291o.ahp().mo43766a(str4, (ImageView) ah.findViewById(2131822922), ahG);
        }
        C35844g.m58780a(c5536q, es);
        AppMethodBeat.m2505o(27692);
        return es;
    }

    /* renamed from: a */
    private static void m58780a(C5536q c5536q, C46633o c46633o) {
        AppMethodBeat.m2504i(27702);
        try {
            if (!c5536q.ylL.isFinishing()) {
                c46633o.setInputMethodMode(1);
                c46633o.setSoftInputMode(16);
                c46633o.setFocusable(true);
                c46633o.setTouchable(true);
                c46633o.showAtLocation(c5536q.ylL.getWindow().getDecorView(), 17, 0, 0);
            }
            AppMethodBeat.m2505o(27702);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMConfirmDialog", "show dialog fail: %s", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.MMConfirmDialog", e, "", new Object[0]);
            AppMethodBeat.m2505o(27702);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m58791b(C5652a c5652a, final Bitmap bitmap) {
        AppMethodBeat.m2504i(27705);
        c5652a.mo11458a(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(27648);
                if (bitmap == null || bitmap.isRecycled()) {
                    AppMethodBeat.m2505o(27648);
                    return;
                }
                C4990ab.m7417i("MicroMsg.MMConfirmDialog", "bitmap recycle %s", bitmap.toString());
                bitmap.recycle();
                AppMethodBeat.m2505o(27648);
            }
        });
        AppMethodBeat.m2505o(27705);
    }

    /* renamed from: et */
    static /* synthetic */ String m58794et(View view) {
        AppMethodBeat.m2504i(27709);
        EditText editText = (EditText) view.findViewById(2131822921);
        if (editText == null) {
            AppMethodBeat.m2505o(27709);
            return null;
        }
        String obj = editText.getText().toString();
        AppMethodBeat.m2505o(27709);
        return obj;
    }

    /* renamed from: eu */
    static /* synthetic */ int m58795eu(View view) {
        AppMethodBeat.m2504i(27710);
        EditText editText = (EditText) view.findViewById(2131822921);
        if (editText instanceof PasterEditText) {
            int pasterLen = ((PasterEditText) editText).getPasterLen();
            AppMethodBeat.m2505o(27710);
            return pasterLen;
        }
        AppMethodBeat.m2505o(27710);
        return 0;
    }
}
