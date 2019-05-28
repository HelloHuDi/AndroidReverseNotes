package com.tencent.p177mm.p612ui.chatting.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.C17391c;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.picker.OptionPicker;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.Calendar;

/* renamed from: com.tencent.mm.ui.chatting.view.b */
public final class C30578b {
    private Button grC;
    private View iym;
    private Button jAH;
    Context mContext;
    /* renamed from: nA */
    private BottomSheetBehavior f13742nA;
    OptionPicker zaU;
    OptionPicker zaV;
    C17391c zaW;
    private int zaX;
    public C30581a zaY;
    ArrayList<Long> zaZ = new ArrayList(42);

    /* renamed from: com.tencent.mm.ui.chatting.view.b$2 */
    class C238162 implements OnValueChangeListener {
        C238162() {
        }

        public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
            AppMethodBeat.m2504i(32777);
            C4990ab.m7411d("MicroMsg.MMRemindDatePicker", "[onValueChange] oldVal:%s newVal:%s", Integer.valueOf(i), Integer.valueOf(i2));
            C30578b.this.zaV.setOptionsArray(C30578b.this.mo48982Pk(i2));
            int i3 = Calendar.getInstance().get(11);
            if (i2 == 0) {
                C30578b.this.zaV.setValue(0);
                AppMethodBeat.m2505o(32777);
                return;
            }
            C30578b.this.zaV.setValue(i3);
            AppMethodBeat.m2505o(32777);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.view.b$1 */
    class C305771 implements OnDismissListener {
        C305771() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            C30578b.this.zaW = null;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.view.b$3 */
    class C305793 implements OnClickListener {
        C305793() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(32778);
            if (C30578b.this.zaY != null) {
                C30581a c30581a = C30578b.this.zaY;
                C30578b c30578b = C30578b.this;
                long currentTimeMillis = System.currentTimeMillis();
                int value = c30578b.zaU.getValue();
                int value2 = c30578b.zaV.getValue();
                if (value != 0) {
                    currentTimeMillis = ((Long) c30578b.zaZ.get(value)).longValue() + (((long) (value2 + 1)) * 3600000);
                } else if (C4872b.dnO()) {
                    currentTimeMillis += 360000;
                } else {
                    currentTimeMillis += ((long) (value2 + 1)) * 3600000;
                }
                String formatTime = C14835h.formatTime(c30578b.mContext.getString(C25738R.string.bxf) + "HH:mm", currentTimeMillis / 1000);
                C4990ab.m7417i("MicroMsg.MMRemindDatePicker", "[getTimestamp] date:%s", formatTime);
                c30581a.mo39544ne(currentTimeMillis);
            }
            AppMethodBeat.m2505o(32778);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.view.b$4 */
    class C305804 implements OnClickListener {
        C305804() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(32779);
            if (C30578b.this.zaY != null) {
                C30578b.this.zaY.onCancel();
            }
            AppMethodBeat.m2505o(32779);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.view.b$a */
    public interface C30581a {
        /* renamed from: ne */
        void mo39544ne(long j);

        void onCancel();
    }

    public C30578b(Context context) {
        AppMethodBeat.m2504i(32780);
        this.mContext = context;
        this.iym = View.inflate(this.mContext, 2130970504, null);
        this.zaW = new C17391c(this.mContext);
        this.zaW.setContentView(this.iym);
        this.zaW.setOnDismissListener(new C305771());
        this.zaU = (OptionPicker) this.iym.findViewById(2131826963);
        this.zaV = (OptionPicker) this.iym.findViewById(2131826451);
        this.zaU.setValue(0);
        this.zaU.setMinWidth(C1338a.fromDPToPix(this.mContext, 60));
        this.zaV.setMinWidth(C1338a.fromDPToPix(this.mContext, 60));
        this.zaU.setOptionsArray(dHi());
        this.zaV.setOptionsArray(mo48982Pk(0));
        this.zaU.setOnValueChangedListener(new C238162());
        LayoutParams layoutParams = (LayoutParams) this.iym.getLayoutParams();
        layoutParams.height = C1338a.fromDPToPix(this.mContext, C31128d.MIC_PTU_YOUJIALI);
        this.iym.setLayoutParams(layoutParams);
        this.zaX = C1338a.fromDPToPix(this.mContext, 350);
        this.f13742nA = BottomSheetBehavior.m38322j((View) this.iym.getParent());
        if (this.f13742nA != null) {
            this.f13742nA.mo41462K(this.zaX);
            this.f13742nA.f4913nj = false;
        }
        this.grC = (Button) this.iym.findViewById(2131823196);
        this.grC.setOnClickListener(new C305793());
        this.jAH = (Button) this.iym.findViewById(2131822819);
        this.jAH.setOnClickListener(new C305804());
        AppMethodBeat.m2505o(32780);
    }

    public final void show() {
        AppMethodBeat.m2504i(32781);
        if (this.zaW != null) {
            this.zaW.show();
        }
        AppMethodBeat.m2505o(32781);
    }

    public final void hide() {
        AppMethodBeat.m2504i(32782);
        if (this.zaW != null) {
            this.zaW.dismiss();
        }
        AppMethodBeat.m2505o(32782);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Pk */
    public final String[] mo48982Pk(int i) {
        int i2;
        int i3 = 1;
        AppMethodBeat.m2504i(32783);
        ArrayList arrayList = new ArrayList();
        if (C4872b.dnO()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        switch (i - i2) {
            case -1:
                arrayList.add("after 6 min");
                break;
            case 0:
                int i4 = Calendar.getInstance().get(11);
                for (i2 = 1; i2 <= 24 - i4; i2++) {
                    arrayList.add(this.mContext.getResources().getString(C25738R.string.f8792f5, new Object[]{Integer.valueOf(i2)}));
                }
                break;
            default:
                while (true) {
                    i2 = i3;
                    if (i2 > 24) {
                        break;
                    }
                    arrayList.add((i2 < 10 ? AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i2)) : Integer.valueOf(i2)) + ":00");
                    i3 = i2 + 1;
                }
        }
        String[] ej = C5046bo.m7547ej(arrayList);
        AppMethodBeat.m2505o(32783);
        return ej;
    }

    private String[] dHi() {
        int i = 0;
        AppMethodBeat.m2504i(32784);
        this.zaZ.clear();
        ArrayList arrayList = new ArrayList();
        Calendar instance = Calendar.getInstance();
        int i2 = 0;
        while (i2 < instance.getActualMaximum(5)) {
            if (C4872b.dnO() && i2 == 0) {
                arrayList.add("test");
                this.zaZ.add(Long.valueOf(instance.getTimeInMillis()));
            }
            if (i2 == 0) {
                instance.setTimeInMillis(System.currentTimeMillis() + (86400000 * ((long) i2)));
                this.zaZ.add(Long.valueOf(instance.getTimeInMillis()));
            } else {
                instance.setTimeInMillis(System.currentTimeMillis() + (86400000 * ((long) i2)));
                instance.set(11, 0);
                instance.set(12, 0);
                instance.set(13, 0);
                instance.set(14, 0);
                this.zaZ.add(Long.valueOf(instance.getTimeInMillis()));
            }
            String formatTime = C14835h.formatTime(this.mContext.getString(C25738R.string.bww), instance.getTimeInMillis() / 1000);
            if (i2 == 0) {
                arrayList.add(this.mContext.getResources().getString(C25738R.string.by3));
            } else if (i2 == 1) {
                arrayList.add(formatTime + " " + this.mContext.getResources().getString(C25738R.string.by4));
            } else if (i2 == 2) {
                arrayList.add(formatTime + " " + this.mContext.getResources().getString(C25738R.string.bxu));
            } else {
                arrayList.add(formatTime + " " + C14835h.m23087af(this.mContext, instance.get(7)));
            }
            i2++;
        }
        i2 = instance.get(1);
        int i3 = instance.get(2) + 1;
        while (i < 12) {
            if (i3 + i > 12) {
                instance.set(1, i2 + 1);
                instance.set(2, (i3 + i) - 12);
            } else {
                instance.set(2, i3 + i);
            }
            instance.set(5, 1);
            this.zaZ.add(Long.valueOf(instance.getTimeInMillis()));
            arrayList.add(String.valueOf(C14835h.formatTime(this.mContext.getString(C25738R.string.bxf), instance.getTimeInMillis() / 1000)));
            i++;
        }
        String[] ej = C5046bo.m7547ej(arrayList);
        AppMethodBeat.m2505o(32784);
        return ej;
    }
}
