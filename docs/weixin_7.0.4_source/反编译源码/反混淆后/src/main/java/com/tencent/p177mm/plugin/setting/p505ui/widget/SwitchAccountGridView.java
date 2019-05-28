package com.tencent.p177mm.plugin.setting.p505ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView */
public class SwitchAccountGridView extends GridLayout {
    private static int qqY;
    private String gCZ;
    private boolean qqZ;
    private boolean qra;
    private boolean qrb;
    public String qrc;
    public boolean qrd;
    public AnimatorSet qre;
    public List<String> qrf = new ArrayList();
    public List<C34891d> qrg = new ArrayList();
    public List<View> qrh = new ArrayList();
    private C34890b qri;
    private C3822a qrj;
    private C39686c qrk;

    /* renamed from: com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView$4 */
    public class C38204 implements AnimatorUpdateListener {
        final /* synthetic */ int qrn;

        public C38204(int i) {
            this.qrn = i;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i = 0;
            AppMethodBeat.m2504i(127705);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            C4990ab.m7417i("MicroMsg.SwitchAccountGridView", "value %f", Float.valueOf(floatValue));
            while (i < this.qrn) {
                if (!((String) SwitchAccountGridView.this.qrf.get(i)).equals(SwitchAccountGridView.this.qrc)) {
                    ((View) SwitchAccountGridView.this.qrh.get(i)).setAlpha(1.0f - floatValue);
                }
                i++;
            }
            if (this.qrn < SwitchAccountGridView.this.getChildCount()) {
                ((View) SwitchAccountGridView.this.qrh.get(this.qrn)).setTranslationX(((float) ((View) SwitchAccountGridView.this.qrh.get(this.qrn)).getWidth()) * floatValue);
            }
            AppMethodBeat.m2505o(127705);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView$5 */
    public class C38215 implements AnimatorUpdateListener {
        final /* synthetic */ int qrn;

        public C38215(int i) {
            this.qrn = i;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(127706);
            C4990ab.m7417i("MicroMsg.SwitchAccountGridView", "value %f", Float.valueOf(((Float) valueAnimator.getAnimatedValue()).floatValue()));
            for (int i = 0; i < this.qrn; i++) {
                if (((String) SwitchAccountGridView.this.qrf.get(i)).equals(SwitchAccountGridView.this.qrc)) {
                    ((View) SwitchAccountGridView.this.qrh.get(i)).setTranslationX(((float) (((SwitchAccountGridView.this.getWidth() / 2) - (((View) SwitchAccountGridView.this.qrh.get(i)).getWidth() * i)) - (((View) SwitchAccountGridView.this.qrh.get(i)).getWidth() / 2))) * r3);
                    AppMethodBeat.m2505o(127706);
                    return;
                }
            }
            AppMethodBeat.m2505o(127706);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView$a */
    public interface C3822a {
        void cjg();
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView$3 */
    class C132463 implements OnClickListener {
        C132463() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(127704);
            C4990ab.m7416i("MicroMsg.SwitchAccountGridView", "click addBtn");
            if (SwitchAccountGridView.this.qri != null) {
                SwitchAccountGridView.this.qri.mo37250Wy(null);
            }
            AppMethodBeat.m2505o(127704);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView$6 */
    public class C348896 extends AnimatorListenerAdapter {
        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(127707);
            C4990ab.m7416i("MicroMsg.SwitchAccountGridView", "avatar animator end");
            SwitchAccountGridView.this.qrd = false;
            if (SwitchAccountGridView.this.qrj != null) {
                SwitchAccountGridView.this.qrj.cjg();
            }
            AppMethodBeat.m2505o(127707);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView$b */
    public interface C34890b {
        /* renamed from: Wy */
        void mo37250Wy(String str);
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView$d */
    class C34891d {
        public ImageView goC;
        public TextView nmj;
        public ImageView qpr;
        public View qro;

        private C34891d() {
        }

        /* synthetic */ C34891d(SwitchAccountGridView switchAccountGridView, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView$c */
    public interface C39686c {
        /* renamed from: Wz */
        void mo37255Wz(String str);
    }

    public SwitchAccountGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(127708);
        qqY = getResources().getDimensionPixelOffset(C25738R.dimen.f9724dp) * 2;
        AppMethodBeat.m2505o(127708);
    }

    /* renamed from: ab */
    public final void mo69065ab(Map<String, SwitchAccountModel> map) {
        AppMethodBeat.m2504i(127709);
        if (!(map == null || map.isEmpty())) {
            this.qrf.addAll(map.keySet());
            Collections.sort(this.qrf);
        }
        C4990ab.m7417i("MicroMsg.SwitchAccountGridView", "account count %d", Integer.valueOf(this.qrf.size()));
        int i = 0;
        while (true) {
            int i2 = i;
            ImageView imageView;
            ImageView imageView2;
            if (i2 < this.qrf.size()) {
                View inflate = ((Activity) getContext()).getLayoutInflater().inflate(2130970645, null);
                imageView = (ImageView) inflate.findViewById(2131827435);
                imageView2 = (ImageView) inflate.findViewById(2131827436);
                View findViewById = inflate.findViewById(2131827438);
                final String str = (String) this.qrf.get(i2);
                TextView textView = (TextView) inflate.findViewById(2131827437);
                C34891d c34891d = new C34891d(this, (byte) 0);
                c34891d.goC = imageView;
                c34891d.qpr = imageView2;
                c34891d.nmj = textView;
                c34891d.qro = findViewById;
                imageView.setScaleType(ScaleType.FIT_XY);
                String str2 = ((SwitchAccountModel) map.get(str)).mnu;
                try {
                    if (!C5046bo.isNullOrNil(str2)) {
                        Bitmap decodeByteArray;
                        if (this.qrb) {
                            C4990ab.m7416i("MicroMsg.SwitchAccountGridView", "use system decoder!");
                            byte[] e = C5730e.m8632e(str2, 0, (int) C5730e.asZ(str2));
                            if (e != null) {
                                decodeByteArray = BitmapFactory.decodeByteArray(e, 0, e.length);
                                if (decodeByteArray != null) {
                                    imageView.setImageBitmap(decodeByteArray);
                                }
                            }
                        } else {
                            decodeByteArray = C41732d.m73528qi(str2);
                            if (decodeByteArray != null) {
                                imageView.setImageBitmap(decodeByteArray);
                            } else {
                                C40460b.m69434b(c34891d.goC, str);
                            }
                        }
                    }
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace("MicroMsg.SwitchAccountGridView", e2, "get avatar error", new Object[0]);
                }
                textView.setText(C44089j.m79293b(getContext(), ((SwitchAccountModel) map.get(str)).username, textView.getTextSize()));
                imageView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(127702);
                        C4990ab.m7417i("MicroMsg.SwitchAccountGridView", "click %s", str);
                        if (!(SwitchAccountGridView.this.qqZ || SwitchAccountGridView.this.qri == null)) {
                            SwitchAccountGridView.this.qri.mo37250Wy(str);
                        }
                        AppMethodBeat.m2505o(127702);
                    }
                });
                imageView2.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(127703);
                        if (SwitchAccountGridView.this.qrk != null) {
                            SwitchAccountGridView.this.qrk.mo37255Wz(str);
                        }
                        AppMethodBeat.m2505o(127703);
                    }
                });
                this.qrg.add(c34891d);
                this.qrh.add(inflate);
                i = i2 + 1;
            } else {
                View inflate2 = ((Activity) getContext()).getLayoutInflater().inflate(2130970645, null);
                imageView = (ImageView) inflate2.findViewById(2131827435);
                imageView2 = (ImageView) inflate2.findViewById(2131827436);
                TextView textView2 = (TextView) inflate2.findViewById(2131827437);
                C34891d c34891d2 = new C34891d(this, (byte) 0);
                c34891d2.goC = imageView;
                c34891d2.qpr = imageView2;
                c34891d2.nmj = textView2;
                imageView.setScaleType(ScaleType.FIT_XY);
                imageView.setImageResource(C25738R.drawable.f6436e4);
                textView2.setText(getContext().getResources().getString(C25738R.string.eba));
                imageView.setOnClickListener(new C132463());
                this.qrg.add(c34891d2);
                this.qrh.add(inflate2);
                AppMethodBeat.m2505o(127709);
                return;
            }
        }
    }

    public final void cjt() {
        AppMethodBeat.m2504i(127710);
        if (this.qrd) {
            C4990ab.m7416i("MicroMsg.SwitchAccountGridView", "playing animation");
            AppMethodBeat.m2505o(127710);
            return;
        }
        removeAllViews();
        int min = Math.min(2, this.qrf.size());
        int i = 0;
        while (i < min) {
            if (!this.qqZ || ((String) this.qrf.get(i)).equals(this.gCZ)) {
                ((C34891d) this.qrg.get(i)).qpr.setVisibility(4);
            } else {
                ((C34891d) this.qrg.get(i)).qpr.setVisibility(0);
            }
            ((C34891d) this.qrg.get(i)).qro.setVisibility(4);
            if (!C5046bo.isNullOrNil(this.gCZ) && ((String) this.qrf.get(i)).equals(this.gCZ)) {
                if (this.qra) {
                    ((ImageView) ((C34891d) this.qrg.get(i)).qro.findViewById(2131827440)).setImageResource(C25738R.drawable.f6769px);
                } else {
                    ((ImageView) ((C34891d) this.qrg.get(i)).qro.findViewById(2131827440)).setImageResource(C25738R.drawable.f6767pv);
                }
                if (this.qra) {
                    ((TextView) ((C34891d) this.qrg.get(i)).qro.findViewById(2131827442)).setText(getContext().getResources().getString(C25738R.string.g35));
                } else {
                    ((TextView) ((C34891d) this.qrg.get(i)).qro.findViewById(2131827442)).setText(getContext().getResources().getString(C25738R.string.ebd));
                }
                ((C34891d) this.qrg.get(i)).qro.findViewById(2131827441).setVisibility(8);
                ((C34891d) this.qrg.get(i)).qro.findViewById(2131827440).setVisibility(0);
                ((C34891d) this.qrg.get(i)).qro.setVisibility(0);
            }
            if (!C5046bo.isNullOrNil(this.qrc) && ((String) this.qrf.get(i)).equals(this.qrc)) {
                ((TextView) ((C34891d) this.qrg.get(i)).qro.findViewById(2131827442)).setText(getContext().getResources().getString(C25738R.string.cou));
                ((C34891d) this.qrg.get(i)).qro.findViewById(2131827440).setVisibility(8);
                ((C34891d) this.qrg.get(i)).qro.findViewById(2131827441).setVisibility(0);
                ((C34891d) this.qrg.get(i)).qro.setVisibility(0);
            }
            LayoutParams layoutParams = new LayoutParams();
            layoutParams.width = qqY;
            addView((View) this.qrh.get(i), layoutParams);
            i++;
        }
        if (getChildCount() < 2) {
            ((C34891d) this.qrg.get(this.qrg.size() - 1)).qpr.setVisibility(4);
            LayoutParams layoutParams2 = new LayoutParams();
            layoutParams2.width = qqY;
            addView((View) this.qrh.get(this.qrh.size() - 1), layoutParams2);
        }
        AppMethodBeat.m2505o(127710);
    }

    public void setDeleteState(boolean z) {
        this.qqZ = z;
    }

    public void setUseSystemDecoder(boolean z) {
        this.qrb = z;
    }

    public int getAccountCount() {
        AppMethodBeat.m2504i(127711);
        int size = this.qrf.size();
        AppMethodBeat.m2505o(127711);
        return size;
    }

    public void setSwitchToWxUsername(String str) {
        this.qrc = str;
    }

    public void setLastLoginWxUsername(String str) {
        this.gCZ = str;
    }

    public void setLogoutState(boolean z) {
        this.qra = z;
    }

    public void setOnClickAvatarListener(C34890b c34890b) {
        this.qri = c34890b;
    }

    public void setOnAnimatorEndListener(C3822a c3822a) {
        this.qrj = c3822a;
    }

    public void setOnDeleteAvatarListener(C39686c c39686c) {
        this.qrk = c39686c;
    }
}
