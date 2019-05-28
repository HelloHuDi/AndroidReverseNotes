package com.tencent.p177mm.p612ui.widget.p633a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.view.View;
import android.widget.RadioGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.AlertActivity;
import com.tencent.p177mm.p612ui.C5229aj;
import com.tencent.p177mm.p612ui.p627e.p628c.C5509b;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a.C5651d;

/* renamed from: com.tencent.mm.ui.widget.a.e */
public final class C5663e {

    /* renamed from: com.tencent.mm.ui.widget.a.e$a */
    public static class C5659a {
        public C5653c gud;
        public Context mContext;
        public final C5652a vkm;
        public String zQJ = null;
        public String zQK = null;
        public boolean zQL = false;
        public boolean zQM = false;
        public RadioGroup zQN;

        /* renamed from: com.tencent.mm.ui.widget.a.e$a$1 */
        class C56601 implements C5651d {
            C56601() {
            }

            /* renamed from: a */
            public final CharSequence mo11445a(CharSequence charSequence, float f) {
                AppMethodBeat.m2504i(112670);
                CharSequence c = C5509b.m8295c(C5659a.this.mContext, charSequence, f);
                AppMethodBeat.m2505o(112670);
                return c;
            }
        }

        public C5659a(Context context) {
            AppMethodBeat.m2504i(112675);
            this.mContext = context;
            this.vkm = new C5652a(this.mContext);
            this.vkm.mo11482rc(false);
            this.vkm.mo11483rd(false);
            this.vkm.mo11460a(new C56601());
            AppMethodBeat.m2505o(112675);
        }

        /* renamed from: re */
        public final C5659a mo11526re(boolean z) {
            AppMethodBeat.m2504i(112676);
            this.vkm.mo11482rc(z);
            this.vkm.mo11483rd(z);
            AppMethodBeat.m2505o(112676);
            return this;
        }

        /* renamed from: al */
        public final C5659a mo11514al(CharSequence charSequence) {
            AppMethodBeat.m2504i(112677);
            int fromDPToPix = C5229aj.fromDPToPix(this.mContext, (int) (20.0f * C5229aj.m7982dm(this.mContext)));
            if (charSequence != null && charSequence.length() > 0) {
                this.vkm.mo11464ai(C5509b.m8296h(this.mContext, charSequence.toString(), fromDPToPix));
            }
            this.vkm.mo11464ai(charSequence);
            AppMethodBeat.m2505o(112677);
            return this;
        }

        public final C5659a asL(String str) {
            AppMethodBeat.m2504i(112678);
            this.vkm.asE(str);
            AppMethodBeat.m2505o(112678);
            return this;
        }

        /* renamed from: am */
        public final C5659a mo11515am(CharSequence charSequence) {
            AppMethodBeat.m2504i(112679);
            int fromDPToPix = C5229aj.fromDPToPix(this.mContext, (int) (14.0f * C5229aj.m7982dm(this.mContext)));
            if (charSequence != null && charSequence.length() > 0) {
                this.vkm.mo11466ak(C5509b.m8296h(this.mContext, charSequence.toString(), fromDPToPix));
            }
            this.vkm.mo11466ak(charSequence);
            AppMethodBeat.m2505o(112679);
            return this;
        }

        public final C5659a asM(String str) {
            AppMethodBeat.m2504i(112680);
            this.vkm.asF(str);
            AppMethodBeat.m2505o(112680);
            return this;
        }

        /* renamed from: fo */
        public final C5659a mo11524fo(View view) {
            AppMethodBeat.m2504i(112681);
            this.vkm.mo11479fn(view);
            AppMethodBeat.m2505o(112681);
            return this;
        }

        /* renamed from: m */
        public final C5659a mo11525m(Boolean bool) {
            AppMethodBeat.m2504i(112682);
            this.vkm.mo11481rb(bool.booleanValue());
            AppMethodBeat.m2505o(112682);
            return this;
        }

        public final C5659a asN(String str) {
            AppMethodBeat.m2504i(112683);
            this.vkm.asH(str);
            AppMethodBeat.m2505o(112683);
            return this;
        }

        public final C5659a asO(String str) {
            AppMethodBeat.m2504i(112684);
            this.vkm.asI(str);
            AppMethodBeat.m2505o(112684);
            return this;
        }

        /* renamed from: Qg */
        public final C5659a mo11509Qg(int i) {
            AppMethodBeat.m2504i(112685);
            this.zQJ = this.mContext.getResources().getString(i);
            AppMethodBeat.m2505o(112685);
            return this;
        }

        public final C5659a asP(String str) {
            this.zQJ = str;
            return this;
        }

        /* renamed from: Qh */
        public final C5659a mo11510Qh(int i) {
            AppMethodBeat.m2504i(112686);
            this.vkm.mo11455Qe(i);
            AppMethodBeat.m2505o(112686);
            return this;
        }

        /* renamed from: a */
        public final C5659a mo11513a(C5662c c5662c, C5662c c5662c2) {
            AppMethodBeat.m2504i(112687);
            if (this.zQN != null) {
                this.zQN.setTag(this.gud);
            }
            mo11512a(c5662c);
            mo11522b(c5662c2);
            if (this.zQL) {
                this.vkm.mo11456Qf(this.mContext.getResources().getColor(C25738R.color.f11795hi));
            }
            AppMethodBeat.m2505o(112687);
            return this;
        }

        /* renamed from: a */
        public final C5659a mo11512a(final C5662c c5662c) {
            AppMethodBeat.m2504i(112688);
            if (this.zQK == null || (this.zQK != null && this.zQK.length() == 0)) {
                this.zQK = this.mContext.getResources().getString(C25738R.string.abn);
            }
            this.vkm.asK(this.zQK);
            if (!this.zQM) {
                this.vkm.mo11476b(new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(112671);
                        if (c5662c != null) {
                            c5662c.mo5699d(false, null);
                        }
                        AppMethodBeat.m2505o(112671);
                    }
                });
            }
            AppMethodBeat.m2505o(112688);
            return this;
        }

        /* renamed from: b */
        public final C5659a mo11522b(final C5662c c5662c) {
            AppMethodBeat.m2504i(112689);
            if (this.zQJ == null || (this.zQJ != null && this.zQJ.length() == 0)) {
                this.zQJ = this.mContext.getResources().getString(C25738R.string.abo);
            }
            this.vkm.asJ(this.zQJ);
            this.vkm.mo11457a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(112672);
                    if (c5662c != null) {
                        c5662c.mo5699d(true, dialogInterface == null ? null : ((C5653c) dialogInterface).dKV());
                    }
                    AppMethodBeat.m2505o(112672);
                }
            });
            AppMethodBeat.m2505o(112689);
            return this;
        }

        /* renamed from: c */
        public final C5659a mo11523c(C5662c c5662c) {
            AppMethodBeat.m2504i(112690);
            if (this.zQN != null) {
                this.zQN.setTag(this.gud);
            }
            mo11522b(c5662c);
            mo11512a(c5662c);
            AppMethodBeat.m2505o(112690);
            return this;
        }

        /* renamed from: a */
        public final C5659a mo11511a(final C5661b c5661b) {
            AppMethodBeat.m2504i(112691);
            if (this.zQN != null) {
                this.zQN.setTag(this.gud);
            }
            if (this.zQJ == null || (this.zQJ != null && this.zQJ.length() == 0)) {
                this.zQJ = this.mContext.getResources().getString(C25738R.string.abo);
            }
            this.vkm.asJ(this.zQJ);
            this.vkm.mo11457a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(112673);
                    if (c5661b != null) {
                        if (dialogInterface != null) {
                            ((C5653c) dialogInterface).dKV();
                        }
                        c5661b.mo11528s(true, dialogInterface == null ? false : ((C5653c) dialogInterface).aaY.isChecked());
                    }
                    AppMethodBeat.m2505o(112673);
                }
            });
            if (this.zQK == null || (this.zQK != null && this.zQK.length() == 0)) {
                this.zQK = this.mContext.getResources().getString(C25738R.string.abn);
            }
            this.vkm.asK(this.zQK);
            if (!this.zQM) {
                this.vkm.mo11476b(new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(112674);
                        if (c5661b != null) {
                            c5661b.mo11528s(false, dialogInterface == null ? false : ((C5653c) dialogInterface).aaY.isChecked());
                        }
                        AppMethodBeat.m2505o(112674);
                    }
                });
            }
            AppMethodBeat.m2505o(112691);
            return this;
        }

        /* renamed from: b */
        public final C5659a mo11521b(OnDismissListener onDismissListener) {
            AppMethodBeat.m2504i(112692);
            this.vkm.mo11458a(onDismissListener);
            AppMethodBeat.m2505o(112692);
            return this;
        }

        public final void show() {
            AppMethodBeat.m2504i(112693);
            if (this.mContext instanceof Activity) {
                if (this.gud == null) {
                    this.gud = this.vkm.aMb();
                }
                this.gud.show();
                AppMethodBeat.m2505o(112693);
                return;
            }
            AlertActivity.m13630a(this.vkm);
            Intent intent = new Intent(this.mContext, AlertActivity.class);
            intent.setFlags(335544320);
            this.mContext.startActivity(intent);
            AppMethodBeat.m2505o(112693);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.a.e$b */
    public interface C5661b {
        /* renamed from: s */
        void mo11528s(boolean z, boolean z2);
    }

    /* renamed from: com.tencent.mm.ui.widget.a.e$c */
    public interface C5662c {
        /* renamed from: d */
        void mo5699d(boolean z, String str);
    }
}
