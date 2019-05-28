package com.eclipsesource.p096a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C19410e;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.view.C31128d;
import com.tencent.wcdb.FileUtils;
import java.io.Reader;
import java.io.StringReader;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.eclipsesource.a.f */
final class C8569f {
    private int aLA;
    private int aLB;
    private StringBuilder aLC;
    private int aLD;
    private final char[] aLx;
    private int aLy;
    private int aLz;
    private int index;
    private int line;
    private final Reader reader;

    C8569f(String str) {
        this(new StringReader(str), Math.max(10, Math.min(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, str.length())));
        AppMethodBeat.m2504i(70555);
        AppMethodBeat.m2505o(70555);
    }

    private C8569f(Reader reader, int i) {
        AppMethodBeat.m2504i(70556);
        this.reader = reader;
        this.aLx = new char[i];
        this.line = 1;
        this.aLD = -1;
        AppMethodBeat.m2505o(70556);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: oT */
    public final C0803h mo18686oT() {
        AppMethodBeat.m2504i(70557);
        C0803h pa;
        switch (this.aLB) {
            case 34:
                pa = m15246pa();
                AppMethodBeat.m2505o(70557);
                return pa;
            case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
            case 48:
            case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
            case 50:
            case 51:
            case 52:
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
            case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
            case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
            case FileUtils.S_IRWXG /*56*/:
            case C19410e.CTRL_INDEX /*57*/:
                pa = m15249pd();
                AppMethodBeat.m2505o(70557);
                return pa;
            case PlayerException.EXCEPTION_IN_PREPARE /*91*/:
                pa = m15240oU();
                AppMethodBeat.m2505o(70557);
                return pa;
            case 102:
                pa = m15245oZ();
                AppMethodBeat.m2505o(70557);
                return pa;
            case 110:
                pa = m15243oX();
                AppMethodBeat.m2505o(70557);
                return pa;
            case 116:
                pa = m15244oY();
                AppMethodBeat.m2505o(70557);
                return pa;
            case 123:
                pa = m15241oV();
                AppMethodBeat.m2505o(70557);
                return pa;
            default:
                C31988j al = m15238al("value");
                AppMethodBeat.m2505o(70557);
                throw al;
        }
    }

    /* renamed from: oU */
    private C37205b m15240oU() {
        AppMethodBeat.m2504i(70558);
        mo18688pi();
        C37205b c37205b = new C37205b();
        mo18687ph();
        if (m15239b(']')) {
            AppMethodBeat.m2505o(70558);
        } else {
            do {
                mo18687ph();
                c37205b.mo59301a(mo18686oT());
                mo18687ph();
            } while (m15239b(','));
            if (m15239b(']')) {
                AppMethodBeat.m2505o(70558);
            } else {
                C31988j al = m15238al("',' or ']'");
                AppMethodBeat.m2505o(70558);
                throw al;
            }
        }
        return c37205b;
    }

    /* renamed from: oV */
    private C31986e m15241oV() {
        AppMethodBeat.m2504i(70559);
        mo18688pi();
        C31986e c31986e = new C31986e();
        mo18687ph();
        if (m15239b('}')) {
            AppMethodBeat.m2505o(70559);
        } else {
            C31988j al;
            do {
                mo18687ph();
                String oW = m15242oW();
                mo18687ph();
                if (m15239b(':')) {
                    mo18687ph();
                    c31986e.mo52093a(oW, mo18686oT());
                    mo18687ph();
                } else {
                    al = m15238al("':'");
                    AppMethodBeat.m2505o(70559);
                    throw al;
                }
            } while (m15239b(','));
            if (m15239b('}')) {
                AppMethodBeat.m2505o(70559);
            } else {
                al = m15238al("',' or '}'");
                AppMethodBeat.m2505o(70559);
                throw al;
            }
        }
        return c31986e;
    }

    /* renamed from: oW */
    private String m15242oW() {
        AppMethodBeat.m2504i(70560);
        if (this.aLB != 34) {
            C31988j al = m15238al("name");
            AppMethodBeat.m2505o(70560);
            throw al;
        }
        String pb = m15247pb();
        AppMethodBeat.m2505o(70560);
        return pb;
    }

    /* renamed from: oX */
    private C0803h m15243oX() {
        AppMethodBeat.m2504i(70561);
        mo18688pi();
        m15237a('u');
        m15237a('l');
        m15237a('l');
        C0803h c0803h = C25470a.aLi;
        AppMethodBeat.m2505o(70561);
        return c0803h;
    }

    /* renamed from: oY */
    private C0803h m15244oY() {
        AppMethodBeat.m2504i(70562);
        mo18688pi();
        m15237a('r');
        m15237a('u');
        m15237a('e');
        C0803h c0803h = C25470a.aLj;
        AppMethodBeat.m2505o(70562);
        return c0803h;
    }

    /* renamed from: oZ */
    private C0803h m15245oZ() {
        AppMethodBeat.m2504i(70563);
        mo18688pi();
        m15237a('a');
        m15237a('l');
        m15237a('s');
        m15237a('e');
        C0803h c0803h = C25470a.aLk;
        AppMethodBeat.m2505o(70563);
        return c0803h;
    }

    /* renamed from: a */
    private void m15237a(char c) {
        AppMethodBeat.m2504i(70564);
        if (m15239b(c)) {
            AppMethodBeat.m2505o(70564);
            return;
        }
        C31988j al = m15238al("'" + c + "'");
        AppMethodBeat.m2505o(70564);
        throw al;
    }

    /* renamed from: pa */
    private C0803h m15246pa() {
        AppMethodBeat.m2504i(70565);
        C8570g c8570g = new C8570g(m15247pb());
        AppMethodBeat.m2505o(70565);
        return c8570g;
    }

    /* renamed from: pb */
    private String m15247pb() {
        AppMethodBeat.m2504i(70566);
        mo18688pi();
        m15253pj();
        while (this.aLB != 34) {
            if (this.aLB == 92) {
                m15254pk();
                m15248pc();
                m15253pj();
            } else if (this.aLB < 32) {
                C31988j al = m15238al("valid string character");
                AppMethodBeat.m2505o(70566);
                throw al;
            } else {
                mo18688pi();
            }
        }
        String pl = m15255pl();
        mo18688pi();
        AppMethodBeat.m2505o(70566);
        return pl;
    }

    /* renamed from: pc */
    private void m15248pc() {
        AppMethodBeat.m2504i(70567);
        mo18688pi();
        C31988j al;
        switch (this.aLB) {
            case 34:
            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
            case 92:
                this.aLC.append((char) this.aLB);
                break;
            case 98:
                this.aLC.append(8);
                break;
            case 102:
                this.aLC.append(12);
                break;
            case 110:
                this.aLC.append(10);
                break;
            case 114:
                this.aLC.append(13);
                break;
            case 116:
                this.aLC.append(9);
                break;
            case C31128d.MIC_ALPHA_ADJUST_REAL /*117*/:
                char[] cArr = new char[4];
                int i = 0;
                while (i < 4) {
                    mo18688pi();
                    if (m15258po()) {
                        cArr[i] = (char) this.aLB;
                        i++;
                    } else {
                        al = m15238al("hexadecimal digit");
                        AppMethodBeat.m2505o(70567);
                        throw al;
                    }
                }
                this.aLC.append((char) Integer.parseInt(new String(cArr), 16));
                break;
            default:
                al = m15238al("valid escape sequence");
                AppMethodBeat.m2505o(70567);
                throw al;
        }
        mo18688pi();
        AppMethodBeat.m2505o(70567);
    }

    /* renamed from: pd */
    private C0803h m15249pd() {
        AppMethodBeat.m2504i(70568);
        m15253pj();
        m15239b('-');
        int i = this.aLB;
        if (m15252pg()) {
            if (i != 48) {
                do {
                } while (m15252pg());
            }
            m15250pe();
            m15251pf();
            C37207d c37207d = new C37207d(m15255pl());
            AppMethodBeat.m2505o(70568);
            return c37207d;
        }
        C31988j al = m15238al("digit");
        AppMethodBeat.m2505o(70568);
        throw al;
    }

    /* renamed from: pe */
    private boolean m15250pe() {
        AppMethodBeat.m2504i(70569);
        if (!m15239b('.')) {
            AppMethodBeat.m2505o(70569);
            return false;
        } else if (m15252pg()) {
            do {
            } while (m15252pg());
            AppMethodBeat.m2505o(70569);
            return true;
        } else {
            C31988j al = m15238al("digit");
            AppMethodBeat.m2505o(70569);
            throw al;
        }
    }

    /* renamed from: pf */
    private boolean m15251pf() {
        AppMethodBeat.m2504i(70570);
        if (m15239b('e') || m15239b('E')) {
            if (!m15239b('+')) {
                m15239b('-');
            }
            if (m15252pg()) {
                do {
                } while (m15252pg());
                AppMethodBeat.m2505o(70570);
                return true;
            }
            C31988j al = m15238al("digit");
            AppMethodBeat.m2505o(70570);
            throw al;
        }
        AppMethodBeat.m2505o(70570);
        return false;
    }

    /* renamed from: b */
    private boolean m15239b(char c) {
        AppMethodBeat.m2504i(70571);
        if (this.aLB != c) {
            AppMethodBeat.m2505o(70571);
            return false;
        }
        mo18688pi();
        AppMethodBeat.m2505o(70571);
        return true;
    }

    /* renamed from: pg */
    private boolean m15252pg() {
        AppMethodBeat.m2504i(70572);
        if (m15257pn()) {
            mo18688pi();
            AppMethodBeat.m2505o(70572);
            return true;
        }
        AppMethodBeat.m2505o(70572);
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ph */
    public final void mo18687ph() {
        AppMethodBeat.m2504i(70573);
        while (m15256pm()) {
            mo18688pi();
        }
        AppMethodBeat.m2505o(70573);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: pi */
    public final void mo18688pi() {
        AppMethodBeat.m2504i(70574);
        if (this.index == this.aLz) {
            if (this.aLD != -1) {
                this.aLC.append(this.aLx, this.aLD, this.aLz - this.aLD);
                this.aLD = 0;
            }
            this.aLy += this.aLz;
            this.aLz = this.reader.read(this.aLx, 0, this.aLx.length);
            this.index = 0;
            if (this.aLz == -1) {
                this.aLB = -1;
                AppMethodBeat.m2505o(70574);
                return;
            }
        }
        if (this.aLB == 10) {
            this.line++;
            this.aLA = this.aLy + this.index;
        }
        char[] cArr = this.aLx;
        int i = this.index;
        this.index = i + 1;
        this.aLB = cArr[i];
        AppMethodBeat.m2505o(70574);
    }

    /* renamed from: pj */
    private void m15253pj() {
        AppMethodBeat.m2504i(70575);
        if (this.aLC == null) {
            this.aLC = new StringBuilder();
        }
        this.aLD = this.index - 1;
        AppMethodBeat.m2505o(70575);
    }

    /* renamed from: pk */
    private void m15254pk() {
        AppMethodBeat.m2504i(70576);
        int i = this.aLB == -1 ? this.index : this.index - 1;
        StringBuilder stringBuilder = this.aLC;
        char[] cArr = this.aLx;
        int i2 = this.aLD;
        stringBuilder.append(cArr, i2, i - i2);
        this.aLD = -1;
        AppMethodBeat.m2505o(70576);
    }

    /* renamed from: pl */
    private String m15255pl() {
        String stringBuilder;
        AppMethodBeat.m2504i(70577);
        int i = this.aLB == -1 ? this.index : this.index - 1;
        if (this.aLC.length() > 0) {
            StringBuilder stringBuilder2 = this.aLC;
            char[] cArr = this.aLx;
            int i2 = this.aLD;
            stringBuilder2.append(cArr, i2, i - i2);
            stringBuilder = this.aLC.toString();
            this.aLC.setLength(0);
        } else {
            stringBuilder = new String(this.aLx, this.aLD, i - this.aLD);
        }
        this.aLD = -1;
        AppMethodBeat.m2505o(70577);
        return stringBuilder;
    }

    /* renamed from: al */
    private C31988j m15238al(String str) {
        AppMethodBeat.m2504i(70578);
        C31988j am;
        if (mo18689pp()) {
            am = mo18685am("Unexpected end of input");
            AppMethodBeat.m2505o(70578);
            return am;
        }
        am = mo18685am("Expected ".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(70578);
        return am;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: am */
    public final C31988j mo18685am(String str) {
        AppMethodBeat.m2504i(70579);
        int i = this.aLy + this.index;
        int i2 = i - this.aLA;
        if (!mo18689pp()) {
            i--;
        }
        C31988j c31988j = new C31988j(str, i, this.line, i2 - 1);
        AppMethodBeat.m2505o(70579);
        return c31988j;
    }

    /* renamed from: pm */
    private boolean m15256pm() {
        return this.aLB == 32 || this.aLB == 9 || this.aLB == 10 || this.aLB == 13;
    }

    /* renamed from: pn */
    private boolean m15257pn() {
        return this.aLB >= 48 && this.aLB <= 57;
    }

    /* renamed from: po */
    private boolean m15258po() {
        return (this.aLB >= 48 && this.aLB <= 57) || ((this.aLB >= 97 && this.aLB <= 102) || (this.aLB >= 65 && this.aLB <= 70));
    }

    /* Access modifiers changed, original: final */
    /* renamed from: pp */
    public final boolean mo18689pp() {
        return this.aLB == -1;
    }
}
