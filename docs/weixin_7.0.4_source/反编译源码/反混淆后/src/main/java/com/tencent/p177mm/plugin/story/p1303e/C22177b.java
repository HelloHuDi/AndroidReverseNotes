package com.tencent.p177mm.plugin.story.p1303e;

import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C31820v;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/story/data/StoryTimeUtil;", "", "()V", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.e.b */
public final class C22177b {
    private static final String TAG = TAG;
    private static final long rRK = 1000;
    private static final long rRL = (rRK * 60);
    private static final long rRM = (rRL * 60);
    private static final long rRN = (24 * rRM);
    public static final C22178a rRO = new C22178a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0004J\u0015\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001b\u001a\u00020\u0014R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/plugin/story/data/StoryTimeUtil$Companion;", "", "()V", "MILLSECONDS_OF_DAY", "", "getMILLSECONDS_OF_DAY", "()J", "MILLSECONDS_OF_HOUR", "getMILLSECONDS_OF_HOUR", "MILLSECONDS_OF_MINUTE", "getMILLSECONDS_OF_MINUTE", "MILLSECONDS_OF_SECOND", "getMILLSECONDS_OF_SECOND", "TAG", "", "formatDateInGallery", "", "date", "formatDateInGrid", "formatDateToTimeSecond", "", "formatStoryCreateDate", "time", "formatTimeInGrid", "formatTimeSecondToDate", "(Ljava/lang/Integer;)Ljava/lang/String;", "formatTimeSecondToMD", "nowToYear", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.e.b$a */
    public static final class C22178a {
        private C22178a() {
        }

        public /* synthetic */ C22178a(byte b) {
            this();
        }

        public static CharSequence aaf(String str) {
            long timeInMillis;
            AppMethodBeat.m2504i(108988);
            C25052j.m39376p(str, FFmpegMetadataRetriever.METADATA_KEY_DATE);
            try {
                List a = C31820v.m51524a((CharSequence) str, new String[]{"-"});
                timeInMillis = new GregorianCalendar(Integer.parseInt((String) a.get(0)), Integer.parseInt((String) a.get(1)) - 1, Integer.parseInt((String) a.get(2))).getTimeInMillis();
            } catch (Exception e) {
                C4990ab.printErrStackTrace(C22177b.TAG, e, e.getMessage(), new Object[0]);
                timeInMillis = 0;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
            gregorianCalendar2.setTimeInMillis(timeInMillis);
            CharSequence charSequence;
            if (gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(2) == gregorianCalendar2.get(2)) {
                String string = C4996ah.getContext().getString(C25738R.string.es4);
                C25052j.m39375o(string, "MMApplicationContext.get…ry_album_date_this_month)");
                charSequence = string;
                AppMethodBeat.m2505o(108988);
                return charSequence;
            }
            new GregorianCalendar().setTimeInMillis(timeInMillis);
            charSequence = DateFormat.format(C4996ah.getContext().getString(C25738R.string.es3), timeInMillis);
            C25052j.m39375o(charSequence, "DateFormat.format(MMAppl…_album_date_split), time)");
            AppMethodBeat.m2505o(108988);
            return charSequence;
        }

        public static CharSequence aag(String str) {
            long timeInMillis;
            AppMethodBeat.m2504i(138746);
            C25052j.m39376p(str, FFmpegMetadataRetriever.METADATA_KEY_DATE);
            try {
                List a = C31820v.m51524a((CharSequence) str, new String[]{"-"});
                timeInMillis = new GregorianCalendar(Integer.parseInt((String) a.get(0)), Integer.parseInt((String) a.get(1)) - 1, Integer.parseInt((String) a.get(2))).getTimeInMillis();
            } catch (Exception e) {
                C4990ab.printErrStackTrace(C22177b.TAG, e, e.getMessage(), new Object[0]);
                timeInMillis = 0;
            }
            CharSequence format = DateFormat.format(C4996ah.getContext().getString(C25738R.string.g_l), timeInMillis);
            C25052j.m39375o(format, "DateFormat.format(MMAppl…allery_date_split), time)");
            AppMethodBeat.m2505o(138746);
            return format;
        }

        /* renamed from: kX */
        public static int m33805kX(long j) {
            int parseInt;
            AppMethodBeat.m2504i(108989);
            try {
                parseInt = Integer.parseInt(DateFormat.format(C4996ah.getContext().getString(C25738R.string.es2), j).toString());
            } catch (NumberFormatException e) {
                C4990ab.printErrStackTrace(C22177b.TAG, e, "NumberFormatException", new Object[0]);
                parseInt = 0;
            }
            AppMethodBeat.m2505o(108989);
            return parseInt;
        }

        public static int aah(String str) {
            AppMethodBeat.m2504i(108990);
            C25052j.m39376p(str, FFmpegMetadataRetriever.METADATA_KEY_DATE);
            Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(str);
            C25052j.m39375o(parse, "simpleDateFormat.parse(date)");
            int time = (int) (parse.getTime() / 1000);
            AppMethodBeat.m2505o(108990);
            return time;
        }

        /* renamed from: j */
        public static String m33804j(Integer num) {
            AppMethodBeat.m2504i(108991);
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date((num != null ? (long) num.intValue() : 0) * 1000));
            C25052j.m39375o(format, "simpleDateFormat.format(date)");
            AppMethodBeat.m2505o(108991);
            return format;
        }
    }

    static {
        AppMethodBeat.m2504i(108992);
        AppMethodBeat.m2505o(108992);
    }
}
