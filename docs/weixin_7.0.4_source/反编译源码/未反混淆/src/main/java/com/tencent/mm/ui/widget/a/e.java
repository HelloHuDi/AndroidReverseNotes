package com.tencent.mm.ui.widget.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.view.View;
import android.widget.RadioGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.AlertActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.widget.a.c.a.d;

public final class e {

    public static class a {
        public c gud;
        public Context mContext;
        public final com.tencent.mm.ui.widget.a.c.a vkm;
        public String zQJ = null;
        public String zQK = null;
        public boolean zQL = false;
        public boolean zQM = false;
        public RadioGroup zQN;

        public a(Context context) {
            AppMethodBeat.i(112675);
            this.mContext = context;
            this.vkm = new com.tencent.mm.ui.widget.a.c.a(this.mContext);
            this.vkm.rc(false);
            this.vkm.rd(false);
            this.vkm.a(new d() {
                public final CharSequence a(CharSequence charSequence, float f) {
                    AppMethodBeat.i(112670);
                    CharSequence c = com.tencent.mm.ui.e.c.b.c(a.this.mContext, charSequence, f);
                    AppMethodBeat.o(112670);
                    return c;
                }
            });
            AppMethodBeat.o(112675);
        }

        public final a re(boolean z) {
            AppMethodBeat.i(112676);
            this.vkm.rc(z);
            this.vkm.rd(z);
            AppMethodBeat.o(112676);
            return this;
        }

        public final a al(CharSequence charSequence) {
            AppMethodBeat.i(112677);
            int fromDPToPix = aj.fromDPToPix(this.mContext, (int) (20.0f * aj.dm(this.mContext)));
            if (charSequence != null && charSequence.length() > 0) {
                this.vkm.ai(com.tencent.mm.ui.e.c.b.h(this.mContext, charSequence.toString(), fromDPToPix));
            }
            this.vkm.ai(charSequence);
            AppMethodBeat.o(112677);
            return this;
        }

        public final a asL(String str) {
            AppMethodBeat.i(112678);
            this.vkm.asE(str);
            AppMethodBeat.o(112678);
            return this;
        }

        public final a am(CharSequence charSequence) {
            AppMethodBeat.i(112679);
            int fromDPToPix = aj.fromDPToPix(this.mContext, (int) (14.0f * aj.dm(this.mContext)));
            if (charSequence != null && charSequence.length() > 0) {
                this.vkm.ak(com.tencent.mm.ui.e.c.b.h(this.mContext, charSequence.toString(), fromDPToPix));
            }
            this.vkm.ak(charSequence);
            AppMethodBeat.o(112679);
            return this;
        }

        public final a asM(String str) {
            AppMethodBeat.i(112680);
            this.vkm.asF(str);
            AppMethodBeat.o(112680);
            return this;
        }

        public final a fo(View view) {
            AppMethodBeat.i(112681);
            this.vkm.fn(view);
            AppMethodBeat.o(112681);
            return this;
        }

        public final a m(Boolean bool) {
            AppMethodBeat.i(112682);
            this.vkm.rb(bool.booleanValue());
            AppMethodBeat.o(112682);
            return this;
        }

        public final a asN(String str) {
            AppMethodBeat.i(112683);
            this.vkm.asH(str);
            AppMethodBeat.o(112683);
            return this;
        }

        public final a asO(String str) {
            AppMethodBeat.i(112684);
            this.vkm.asI(str);
            AppMethodBeat.o(112684);
            return this;
        }

        public final a Qg(int i) {
            AppMethodBeat.i(112685);
            this.zQJ = this.mContext.getResources().getString(i);
            AppMethodBeat.o(112685);
            return this;
        }

        public final a asP(String str) {
            this.zQJ = str;
            return this;
        }

        public final a Qh(int i) {
            AppMethodBeat.i(112686);
            this.vkm.Qe(i);
            AppMethodBeat.o(112686);
            return this;
        }

        public final a a(c cVar, c cVar2) {
            AppMethodBeat.i(112687);
            if (this.zQN != null) {
                this.zQN.setTag(this.gud);
            }
            a(cVar);
            b(cVar2);
            if (this.zQL) {
                this.vkm.Qf(this.mContext.getResources().getColor(R.color.hi));
            }
            AppMethodBeat.o(112687);
            return this;
        }

        public final a a(final c cVar) {
            AppMethodBeat.i(112688);
            if (this.zQK == null || (this.zQK != null && this.zQK.length() == 0)) {
                this.zQK = this.mContext.getResources().getString(R.string.abn);
            }
            this.vkm.asK(this.zQK);
            if (!this.zQM) {
                this.vkm.b(new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(112671);
                        if (cVar != null) {
                            cVar.d(false, null);
                        }
                        AppMethodBeat.o(112671);
                    }
                });
            }
            AppMethodBeat.o(112688);
            return this;
        }

        public final a b(final c cVar) {
            AppMethodBeat.i(112689);
            if (this.zQJ == null || (this.zQJ != null && this.zQJ.length() == 0)) {
                this.zQJ = this.mContext.getResources().getString(R.string.abo);
            }
            this.vkm.asJ(this.zQJ);
            this.vkm.a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(112672);
                    if (cVar != null) {
                        cVar.d(true, dialogInterface == null ? null : ((c) dialogInterface).dKV());
                    }
                    AppMethodBeat.o(112672);
                }
            });
            AppMethodBeat.o(112689);
            return this;
        }

        public final a c(c cVar) {
            AppMethodBeat.i(112690);
            if (this.zQN != null) {
                this.zQN.setTag(this.gud);
            }
            b(cVar);
            a(cVar);
            AppMethodBeat.o(112690);
            return this;
        }

        public final a a(final b bVar) {
            AppMethodBeat.i(112691);
            if (this.zQN != null) {
                this.zQN.setTag(this.gud);
            }
            if (this.zQJ == null || (this.zQJ != null && this.zQJ.length() == 0)) {
                this.zQJ = this.mContext.getResources().getString(R.string.abo);
            }
            this.vkm.asJ(this.zQJ);
            this.vkm.a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(112673);
                    if (bVar != null) {
                        if (dialogInterface != null) {
                            ((c) dialogInterface).dKV();
                        }
                        bVar.s(true, dialogInterface == null ? false : ((c) dialogInterface).aaY.isChecked());
                    }
                    AppMethodBeat.o(112673);
                }
            });
            if (this.zQK == null || (this.zQK != null && this.zQK.length() == 0)) {
                this.zQK = this.mContext.getResources().getString(R.string.abn);
            }
            this.vkm.asK(this.zQK);
            if (!this.zQM) {
                this.vkm.b(new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(112674);
                        if (bVar != null) {
                            bVar.s(false, dialogInterface == null ? false : ((c) dialogInterface).aaY.isChecked());
                        }
                        AppMethodBeat.o(112674);
                    }
                });
            }
            AppMethodBeat.o(112691);
            return this;
        }

        public final a b(OnDismissListener onDismissListener) {
            AppMethodBeat.i(112692);
            this.vkm.a(onDismissListener);
            AppMethodBeat.o(112692);
            return this;
        }

        public final void show() {
            AppMethodBeat.i(112693);
            if (this.mContext instanceof Activity) {
                if (this.gud == null) {
                    this.gud = this.vkm.aMb();
                }
                this.gud.show();
                AppMethodBeat.o(112693);
                return;
            }
            AlertActivity.a(this.vkm);
            Intent intent = new Intent(this.mContext, AlertActivity.class);
            intent.setFlags(335544320);
            this.mContext.startActivity(intent);
            AppMethodBeat.o(112693);
        }
    }

    public interface b {
        void s(boolean z, boolean z2);
    }

    public interface c {
        void d(boolean z, String str);
    }
}
