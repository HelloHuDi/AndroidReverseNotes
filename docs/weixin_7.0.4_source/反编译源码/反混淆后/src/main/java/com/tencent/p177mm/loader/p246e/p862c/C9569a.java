package com.tencent.p177mm.loader.p246e.p862c;

import com.tencent.p177mm.loader.C45421f;
import com.tencent.p177mm.loader.p1197h.C42161e;
import com.tencent.p177mm.loader.p246e.p247b.C32731f;
import com.tencent.p177mm.loader.p246e.p862c.C31269b.C26361b;
import com.tencent.p177mm.loader.p246e.p862c.C31269b.C9570a;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0004J<\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J@\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\t\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "T", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "transcoder", "(Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;)V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "source", "when", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder$WHENIF;", "asResourceName", "", "ishasTransCoderWhenDownload", "", "libimageloader_release"})
/* renamed from: com.tencent.mm.loader.e.c.a */
public final class C9569a<T> extends C31269b<T> {
    /* renamed from: a */
    public final C42161e<T> mo20890a(C32731f<?> c32731f, C45421f<?, T> c45421f, C42161e<T> c42161e, C26361b c26361b) {
        C42161e<T> c42161e2;
        C42161e c42161e22;
        C25052j.m39376p(c32731f, "targetView");
        C25052j.m39376p(c45421f, "reaper");
        C25052j.m39376p(c42161e, "source");
        C25052j.m39376p(c26361b, "when");
        C31269b c31269b = this.eQG;
        if (!(c31269b instanceof C31269b)) {
            c31269b = null;
        }
        if (c31269b == null) {
            c31269b = this.eQG;
        } else {
            do {
                if (c31269b.eQH == C9570a.HIGH && c26361b == c31269b.eQI) {
                    if (c42161e instanceof C42161e) {
                        c42161e22 = c42161e;
                    } else {
                        c42161e22 = null;
                    }
                    if (c42161e22 == null) {
                        C25052j.dWJ();
                    }
                    c42161e22 = c31269b.mo20889a(c32731f, c45421f, c42161e22);
                    if (!(c42161e22 instanceof C42161e)) {
                        c42161e22 = null;
                    }
                    if (c42161e22 != null) {
                        c42161e = c42161e22;
                    }
                }
                c31269b = c31269b.eQG;
                if (!(c31269b instanceof C31269b)) {
                    c31269b = null;
                    continue;
                }
            } while (c31269b != null);
        }
        c31269b = this.eQG;
        if (!(c31269b instanceof C31269b)) {
            c31269b = null;
        }
        if (c31269b == null) {
            c31269b = this.eQG;
        } else {
            do {
                if (c31269b.eQH == C9570a.NORMAL && c26361b == c31269b.eQI) {
                    if (c42161e instanceof C42161e) {
                        c42161e22 = c42161e;
                    } else {
                        c42161e22 = null;
                    }
                    if (c42161e22 == null) {
                        C25052j.dWJ();
                    }
                    c42161e22 = c31269b.mo20889a(c32731f, c45421f, c42161e22);
                    if (!(c42161e22 instanceof C42161e)) {
                        c42161e22 = null;
                    }
                    if (c42161e22 != null) {
                        c42161e = c42161e22;
                    }
                }
                c31269b = c31269b.eQG;
                if (!(c31269b instanceof C31269b)) {
                    c31269b = null;
                    continue;
                }
            } while (c31269b != null);
        }
        c31269b = this.eQG;
        if (!(c31269b instanceof C31269b)) {
            c31269b = null;
        }
        if (c31269b == null) {
            return c42161e;
        }
        do {
            if (c31269b.eQH == C9570a.LOW && c26361b == c31269b.eQI) {
                if (c42161e instanceof C42161e) {
                    c42161e22 = c42161e;
                } else {
                    c42161e22 = null;
                }
                if (c42161e22 == null) {
                    C25052j.dWJ();
                }
                c42161e22 = c31269b.mo20889a(c32731f, c45421f, c42161e22);
                if (!(c42161e22 instanceof C42161e)) {
                    c42161e22 = null;
                }
                if (c42161e22 != null) {
                    c42161e = c42161e22;
                }
            }
            c31269b = c31269b.eQG;
            if (!(c31269b instanceof C31269b)) {
                c31269b = null;
                continue;
            }
        } while (c31269b != null);
        return c42161e;
    }

    /* renamed from: a */
    public final C42161e<? extends T> mo20889a(C32731f<?> c32731f, C45421f<?, T> c45421f, C42161e<T> c42161e) {
        C25052j.m39376p(c32731f, "targetView");
        C25052j.m39376p(c45421f, "reaper");
        C25052j.m39376p(c42161e, "source");
        return c42161e;
    }

    /* renamed from: lS */
    public final String mo20891lS(String str) {
        C25052j.m39376p(str, "source");
        C31269b c31269b = this.eQG;
        if (c31269b == null) {
            c31269b = this.eQG;
        } else {
            do {
                if (c31269b.eQH == C9570a.HIGH && C26361b.DECODED == c31269b.eQI) {
                    str = str + c31269b.mo20891lS(str);
                }
                c31269b = c31269b.eQG;
            } while (c31269b != null);
        }
        c31269b = this.eQG;
        if (c31269b == null) {
            c31269b = this.eQG;
        } else {
            do {
                if (c31269b.eQH == C9570a.NORMAL && C26361b.DECODED == c31269b.eQI) {
                    str = str + c31269b.mo20891lS(str);
                }
                c31269b = c31269b.eQG;
            } while (c31269b != null);
        }
        c31269b = this.eQG;
        if (c31269b == null) {
            return str;
        }
        do {
            if (c31269b.eQH == C9570a.LOW && C26361b.DECODED == c31269b.eQI) {
                str = str + c31269b.mo20891lS(str);
            }
            c31269b = c31269b.eQG;
        } while (c31269b != null);
        return str;
    }
}
