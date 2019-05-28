package com.tencent.mm.plugin.setting.ui.widget;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
    public List<d> qrg = new ArrayList();
    public List<View> qrh = new ArrayList();
    private b qri;
    private a qrj;
    private c qrk;

    /* renamed from: com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView$4 */
    public class AnonymousClass4 implements AnimatorUpdateListener {
        final /* synthetic */ int qrn;

        public AnonymousClass4(int i) {
            this.qrn = i;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i = 0;
            AppMethodBeat.i(127705);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ab.i("MicroMsg.SwitchAccountGridView", "value %f", Float.valueOf(floatValue));
            while (i < this.qrn) {
                if (!((String) SwitchAccountGridView.this.qrf.get(i)).equals(SwitchAccountGridView.this.qrc)) {
                    ((View) SwitchAccountGridView.this.qrh.get(i)).setAlpha(1.0f - floatValue);
                }
                i++;
            }
            if (this.qrn < SwitchAccountGridView.this.getChildCount()) {
                ((View) SwitchAccountGridView.this.qrh.get(this.qrn)).setTranslationX(((float) ((View) SwitchAccountGridView.this.qrh.get(this.qrn)).getWidth()) * floatValue);
            }
            AppMethodBeat.o(127705);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView$5 */
    public class AnonymousClass5 implements AnimatorUpdateListener {
        final /* synthetic */ int qrn;

        public AnonymousClass5(int i) {
            this.qrn = i;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(127706);
            ab.i("MicroMsg.SwitchAccountGridView", "value %f", Float.valueOf(((Float) valueAnimator.getAnimatedValue()).floatValue()));
            for (int i = 0; i < this.qrn; i++) {
                if (((String) SwitchAccountGridView.this.qrf.get(i)).equals(SwitchAccountGridView.this.qrc)) {
                    ((View) SwitchAccountGridView.this.qrh.get(i)).setTranslationX(((float) (((SwitchAccountGridView.this.getWidth() / 2) - (((View) SwitchAccountGridView.this.qrh.get(i)).getWidth() * i)) - (((View) SwitchAccountGridView.this.qrh.get(i)).getWidth() / 2))) * r3);
                    AppMethodBeat.o(127706);
                    return;
                }
            }
            AppMethodBeat.o(127706);
        }
    }

    public interface a {
        void cjg();
    }

    public interface b {
        void Wy(String str);
    }

    class d {
        public ImageView goC;
        public TextView nmj;
        public ImageView qpr;
        public View qro;

        private d() {
        }

        /* synthetic */ d(SwitchAccountGridView switchAccountGridView, byte b) {
            this();
        }
    }

    public interface c {
        void Wz(String str);
    }

    public SwitchAccountGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(127708);
        qqY = getResources().getDimensionPixelOffset(R.dimen.dp) * 2;
        AppMethodBeat.o(127708);
    }

    public final void ab(Map<String, SwitchAccountModel> map) {
        AppMethodBeat.i(127709);
        if (!(map == null || map.isEmpty())) {
            this.qrf.addAll(map.keySet());
            Collections.sort(this.qrf);
        }
        ab.i("MicroMsg.SwitchAccountGridView", "account count %d", Integer.valueOf(this.qrf.size()));
        int i = 0;
        while (true) {
            int i2 = i;
            ImageView imageView;
            ImageView imageView2;
            if (i2 < this.qrf.size()) {
                View inflate = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.as3, null);
                imageView = (ImageView) inflate.findViewById(R.id.ea_);
                imageView2 = (ImageView) inflate.findViewById(R.id.eaa);
                View findViewById = inflate.findViewById(R.id.eac);
                final String str = (String) this.qrf.get(i2);
                TextView textView = (TextView) inflate.findViewById(R.id.eab);
                d dVar = new d(this, (byte) 0);
                dVar.goC = imageView;
                dVar.qpr = imageView2;
                dVar.nmj = textView;
                dVar.qro = findViewById;
                imageView.setScaleType(ScaleType.FIT_XY);
                String str2 = ((SwitchAccountModel) map.get(str)).mnu;
                try {
                    if (!bo.isNullOrNil(str2)) {
                        Bitmap decodeByteArray;
                        if (this.qrb) {
                            ab.i("MicroMsg.SwitchAccountGridView", "use system decoder!");
                            byte[] e = e.e(str2, 0, (int) e.asZ(str2));
                            if (e != null) {
                                decodeByteArray = BitmapFactory.decodeByteArray(e, 0, e.length);
                                if (decodeByteArray != null) {
                                    imageView.setImageBitmap(decodeByteArray);
                                }
                            }
                        } else {
                            decodeByteArray = com.tencent.mm.ah.d.qi(str2);
                            if (decodeByteArray != null) {
                                imageView.setImageBitmap(decodeByteArray);
                            } else {
                                com.tencent.mm.pluginsdk.ui.a.b.b(dVar.goC, str);
                            }
                        }
                    }
                } catch (Exception e2) {
                    ab.printErrStackTrace("MicroMsg.SwitchAccountGridView", e2, "get avatar error", new Object[0]);
                }
                textView.setText(j.b(getContext(), ((SwitchAccountModel) map.get(str)).username, textView.getTextSize()));
                imageView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(127702);
                        ab.i("MicroMsg.SwitchAccountGridView", "click %s", str);
                        if (!(SwitchAccountGridView.this.qqZ || SwitchAccountGridView.this.qri == null)) {
                            SwitchAccountGridView.this.qri.Wy(str);
                        }
                        AppMethodBeat.o(127702);
                    }
                });
                imageView2.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(127703);
                        if (SwitchAccountGridView.this.qrk != null) {
                            SwitchAccountGridView.this.qrk.Wz(str);
                        }
                        AppMethodBeat.o(127703);
                    }
                });
                this.qrg.add(dVar);
                this.qrh.add(inflate);
                i = i2 + 1;
            } else {
                View inflate2 = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.as3, null);
                imageView = (ImageView) inflate2.findViewById(R.id.ea_);
                imageView2 = (ImageView) inflate2.findViewById(R.id.eaa);
                TextView textView2 = (TextView) inflate2.findViewById(R.id.eab);
                d dVar2 = new d(this, (byte) 0);
                dVar2.goC = imageView;
                dVar2.qpr = imageView2;
                dVar2.nmj = textView2;
                imageView.setScaleType(ScaleType.FIT_XY);
                imageView.setImageResource(R.drawable.e4);
                textView2.setText(getContext().getResources().getString(R.string.eba));
                imageView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(127704);
                        ab.i("MicroMsg.SwitchAccountGridView", "click addBtn");
                        if (SwitchAccountGridView.this.qri != null) {
                            SwitchAccountGridView.this.qri.Wy(null);
                        }
                        AppMethodBeat.o(127704);
                    }
                });
                this.qrg.add(dVar2);
                this.qrh.add(inflate2);
                AppMethodBeat.o(127709);
                return;
            }
        }
    }

    public final void cjt() {
        AppMethodBeat.i(127710);
        if (this.qrd) {
            ab.i("MicroMsg.SwitchAccountGridView", "playing animation");
            AppMethodBeat.o(127710);
            return;
        }
        removeAllViews();
        int min = Math.min(2, this.qrf.size());
        int i = 0;
        while (i < min) {
            if (!this.qqZ || ((String) this.qrf.get(i)).equals(this.gCZ)) {
                ((d) this.qrg.get(i)).qpr.setVisibility(4);
            } else {
                ((d) this.qrg.get(i)).qpr.setVisibility(0);
            }
            ((d) this.qrg.get(i)).qro.setVisibility(4);
            if (!bo.isNullOrNil(this.gCZ) && ((String) this.qrf.get(i)).equals(this.gCZ)) {
                if (this.qra) {
                    ((ImageView) ((d) this.qrg.get(i)).qro.findViewById(R.id.eae)).setImageResource(R.drawable.px);
                } else {
                    ((ImageView) ((d) this.qrg.get(i)).qro.findViewById(R.id.eae)).setImageResource(R.drawable.pv);
                }
                if (this.qra) {
                    ((TextView) ((d) this.qrg.get(i)).qro.findViewById(R.id.eag)).setText(getContext().getResources().getString(R.string.g35));
                } else {
                    ((TextView) ((d) this.qrg.get(i)).qro.findViewById(R.id.eag)).setText(getContext().getResources().getString(R.string.ebd));
                }
                ((d) this.qrg.get(i)).qro.findViewById(R.id.eaf).setVisibility(8);
                ((d) this.qrg.get(i)).qro.findViewById(R.id.eae).setVisibility(0);
                ((d) this.qrg.get(i)).qro.setVisibility(0);
            }
            if (!bo.isNullOrNil(this.qrc) && ((String) this.qrf.get(i)).equals(this.qrc)) {
                ((TextView) ((d) this.qrg.get(i)).qro.findViewById(R.id.eag)).setText(getContext().getResources().getString(R.string.cou));
                ((d) this.qrg.get(i)).qro.findViewById(R.id.eae).setVisibility(8);
                ((d) this.qrg.get(i)).qro.findViewById(R.id.eaf).setVisibility(0);
                ((d) this.qrg.get(i)).qro.setVisibility(0);
            }
            LayoutParams layoutParams = new LayoutParams();
            layoutParams.width = qqY;
            addView((View) this.qrh.get(i), layoutParams);
            i++;
        }
        if (getChildCount() < 2) {
            ((d) this.qrg.get(this.qrg.size() - 1)).qpr.setVisibility(4);
            LayoutParams layoutParams2 = new LayoutParams();
            layoutParams2.width = qqY;
            addView((View) this.qrh.get(this.qrh.size() - 1), layoutParams2);
        }
        AppMethodBeat.o(127710);
    }

    public void setDeleteState(boolean z) {
        this.qqZ = z;
    }

    public void setUseSystemDecoder(boolean z) {
        this.qrb = z;
    }

    public int getAccountCount() {
        AppMethodBeat.i(127711);
        int size = this.qrf.size();
        AppMethodBeat.o(127711);
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

    public void setOnClickAvatarListener(b bVar) {
        this.qri = bVar;
    }

    public void setOnAnimatorEndListener(a aVar) {
        this.qrj = aVar;
    }

    public void setOnDeleteAvatarListener(c cVar) {
        this.qrk = cVar;
    }
}
