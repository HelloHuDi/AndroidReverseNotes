package com.tencent.p177mm.plugin.talkroom.p538ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.MMHorList;
import com.tencent.p177mm.p612ui.base.MMHorList.C15517a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame */
public class TalkRoomAvatarsFrame extends FrameLayout {
    private C7306ak mHandler;
    private String nMN;
    private final int nMz = C1338a.fromDPToPix(null, 58);
    private final int szg = 2000;
    private final int szh = 5;
    private MMHorList szi;
    private C39957a szj;
    private C7564ap szk;

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame$1 */
    class C223951 implements C15517a {

        /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame$1$1 */
        class C223961 implements Runnable {
            C223961() {
            }

            public final void run() {
                AppMethodBeat.m2504i(25890);
                TalkRoomAvatarsFrame.this.szj.notifyDataSetChanged();
                AppMethodBeat.m2505o(25890);
            }
        }

        C223951() {
        }

        public final void cEF() {
            AppMethodBeat.m2504i(25891);
            TalkRoomAvatarsFrame.this.szk.stopTimer();
            AppMethodBeat.m2505o(25891);
        }

        public final void cEG() {
            AppMethodBeat.m2504i(25892);
            TalkRoomAvatarsFrame.this.szk.mo16770ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            AppMethodBeat.m2505o(25892);
        }

        public final void aQe() {
            AppMethodBeat.m2504i(25893);
            TalkRoomAvatarsFrame.this.mHandler.post(new C223961());
            AppMethodBeat.m2505o(25893);
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame$2 */
    class C223972 implements C5015a {
        C223972() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(25894);
            TalkRoomAvatarsFrame.m86857d(TalkRoomAvatarsFrame.this);
            AppMethodBeat.m2505o(25894);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame$a */
    static class C39957a extends BaseAdapter {
        private Context mContext;
        String nMN;
        List<String> szn = new LinkedList();

        /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame$a$a */
        class C39958a {
            public ImageView ejo;
            public TextView ejp;

            C39958a() {
            }
        }

        public C39957a(Context context) {
            AppMethodBeat.m2504i(25895);
            this.mContext = context;
            AppMethodBeat.m2505o(25895);
        }

        public final int indexOf(String str) {
            AppMethodBeat.m2504i(25896);
            int indexOf = this.szn.indexOf(str);
            AppMethodBeat.m2505o(25896);
            return indexOf;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(25897);
            int size = this.szn.size();
            AppMethodBeat.m2505o(25897);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(25898);
            Object obj = this.szn.get(i);
            AppMethodBeat.m2505o(25898);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C39958a c39958a;
            AppMethodBeat.m2504i(25899);
            String str = (String) this.szn.get(i);
            if (view == null) {
                view = View.inflate(this.mContext, 2130970916, null);
                C39958a c39958a2 = new C39958a();
                c39958a2.ejo = (ImageView) view.findViewById(2131828216);
                c39958a2.ejp = (TextView) view.findViewById(2131828217);
                view.setTag(c39958a2);
                c39958a = c39958a2;
            } else {
                c39958a = (C39958a) view.getTag();
            }
            c39958a.ejo.setBackgroundResource(str.equals(this.nMN) ? C25738R.drawable.ap8 : 0);
            c39958a.ejp.setVisibility(8);
            C40460b.m69439t(c39958a.ejo, str);
            AppMethodBeat.m2505o(25899);
            return view;
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m86857d(TalkRoomAvatarsFrame talkRoomAvatarsFrame) {
        AppMethodBeat.m2504i(25906);
        talkRoomAvatarsFrame.bJk();
        AppMethodBeat.m2505o(25906);
    }

    public TalkRoomAvatarsFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(25900);
        initView();
        AppMethodBeat.m2505o(25900);
    }

    public TalkRoomAvatarsFrame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(25901);
        initView();
        AppMethodBeat.m2505o(25901);
    }

    private void initView() {
        AppMethodBeat.m2504i(25902);
        TalkRoomAvatarsFrame.inflate(getContext(), 2130970915, this);
        this.szi = (MMHorList) findViewById(2131828215);
        this.szi.setOverScrollEnabled(true);
        this.szi.setCenterInParent(true);
        this.szi.setItemWidth(this.nMz);
        this.szj = new C39957a(getContext());
        this.szi.setAdapter(this.szj);
        this.mHandler = new C7306ak(Looper.getMainLooper());
        this.szi.setHorListLitener(new C223951());
        this.szk = new C7564ap(new C223972(), false);
        AppMethodBeat.m2505o(25902);
    }

    public void setMembersList(List<String> list) {
        AppMethodBeat.m2504i(25903);
        if (this.szj == null) {
            AppMethodBeat.m2505o(25903);
            return;
        }
        C39957a c39957a = this.szj;
        if (list == null) {
            c39957a.szn.clear();
        } else {
            c39957a.szn = list;
        }
        c39957a.notifyDataSetChanged();
        AppMethodBeat.m2505o(25903);
    }

    public void setCurMemeber(String str) {
        AppMethodBeat.m2504i(25904);
        if (this.szi == null) {
            AppMethodBeat.m2505o(25904);
        } else if (C5046bo.isNullOrNil(this.nMN) && C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(25904);
        } else if (C5046bo.isNullOrNil(this.nMN) || !this.nMN.equals(str)) {
            this.nMN = str;
            bJk();
            AppMethodBeat.m2505o(25904);
        } else {
            AppMethodBeat.m2505o(25904);
        }
    }

    private void bJk() {
        AppMethodBeat.m2504i(25905);
        this.szj.nMN = this.nMN;
        if (C5046bo.isNullOrNil(this.nMN)) {
            this.szj.notifyDataSetChanged();
            AppMethodBeat.m2505o(25905);
        } else if (this.szi.getIsTouching()) {
            AppMethodBeat.m2505o(25905);
        } else {
            int indexOf = this.szj.indexOf(this.nMN) * this.nMz;
            int currentPosition = this.szi.getCurrentPosition();
            if (indexOf < currentPosition) {
                this.szi.mo27652NI(indexOf);
                AppMethodBeat.m2505o(25905);
            } else if (indexOf > currentPosition + (this.nMz * 4)) {
                this.szi.mo27652NI(indexOf - (this.nMz * 4));
                AppMethodBeat.m2505o(25905);
            } else {
                this.szj.notifyDataSetChanged();
                AppMethodBeat.m2505o(25905);
            }
        }
    }
}
