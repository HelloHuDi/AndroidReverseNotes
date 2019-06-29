.class public abstract Landroid/support/v4/widget/a;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v4/widget/a$a;,
        Landroid/support/v4/widget/a$b;
    }
.end annotation


# static fields
.field private static final a:I


# instance fields
.field final b:Landroid/support/v4/widget/a$a;

.field private final c:Landroid/view/animation/Interpolator;

.field final d:Landroid/view/View;

.field private e:Ljava/lang/Runnable;

.field private f:[F

.field private g:[F

.field private h:I

.field private i:I

.field private j:[F

.field private k:[F

.field private l:[F

.field private m:Z

.field n:Z

.field o:Z

.field p:Z

.field private q:Z

.field private r:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 195
    invoke-static {}, Landroid/view/ViewConfiguration;->getTapTimeout()I

    move-result v0

    sput v0, Landroid/support/v4/widget/a;->a:I

    return-void
.end method

.method public constructor <init>(Landroid/view/View;)V
    .locals 5
    .param p1, "target"    # Landroid/view/View;

    .line 210
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 138
    new-instance v0, Landroid/support/v4/widget/a$a;

    invoke-direct {v0}, Landroid/support/v4/widget/a$a;-><init>()V

    iput-object v0, p0, Landroid/support/v4/widget/a;->b:Landroid/support/v4/widget/a$a;

    .line 141
    new-instance v0, Landroid/view/animation/AccelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/AccelerateInterpolator;-><init>()V

    iput-object v0, p0, Landroid/support/v4/widget/a;->c:Landroid/view/animation/Interpolator;

    .line 150
    const/4 v0, 0x2

    new-array v1, v0, [F

    fill-array-data v1, :array_0

    iput-object v1, p0, Landroid/support/v4/widget/a;->f:[F

    .line 153
    new-array v1, v0, [F

    fill-array-data v1, :array_1

    iput-object v1, p0, Landroid/support/v4/widget/a;->g:[F

    .line 162
    new-array v1, v0, [F

    fill-array-data v1, :array_2

    iput-object v1, p0, Landroid/support/v4/widget/a;->j:[F

    .line 165
    new-array v1, v0, [F

    fill-array-data v1, :array_3

    iput-object v1, p0, Landroid/support/v4/widget/a;->k:[F

    .line 168
    new-array v0, v0, [F

    fill-array-data v0, :array_4

    iput-object v0, p0, Landroid/support/v4/widget/a;->l:[F

    .line 211
    iput-object p1, p0, Landroid/support/v4/widget/a;->d:Landroid/view/View;

    .line 213
    invoke-static {}, Landroid/content/res/Resources;->getSystem()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    .line 214
    .local v0, "metrics":Landroid/util/DisplayMetrics;
    iget v1, v0, Landroid/util/DisplayMetrics;->density:F

    const v2, 0x44c4e000    # 1575.0f

    mul-float v2, v2, v1

    const/high16 v3, 0x3f000000    # 0.5f

    add-float/2addr v2, v3

    float-to-int v2, v2

    .line 215
    .local v2, "maxVelocity":I
    const v4, 0x439d8000    # 315.0f

    mul-float v1, v1, v4

    add-float/2addr v1, v3

    float-to-int v1, v1

    .line 216
    .local v1, "minVelocity":I
    int-to-float v3, v2

    int-to-float v4, v2

    invoke-virtual {p0, v3, v4}, Landroid/support/v4/widget/a;->b(FF)Landroid/support/v4/widget/a;

    .line 217
    int-to-float v3, v1

    int-to-float v4, v1

    invoke-virtual {p0, v3, v4}, Landroid/support/v4/widget/a;->c(FF)Landroid/support/v4/widget/a;

    .line 219
    const/4 v3, 0x1

    invoke-virtual {p0, v3}, Landroid/support/v4/widget/a;->d(I)Landroid/support/v4/widget/a;

    .line 220
    const v3, 0x7f7fffff    # Float.MAX_VALUE

    invoke-virtual {p0, v3, v3}, Landroid/support/v4/widget/a;->a(FF)Landroid/support/v4/widget/a;

    .line 221
    const v3, 0x3e4ccccd    # 0.2f

    invoke-virtual {p0, v3, v3}, Landroid/support/v4/widget/a;->d(FF)Landroid/support/v4/widget/a;

    .line 222
    const/high16 v3, 0x3f800000    # 1.0f

    invoke-virtual {p0, v3, v3}, Landroid/support/v4/widget/a;->e(FF)Landroid/support/v4/widget/a;

    .line 223
    sget v3, Landroid/support/v4/widget/a;->a:I

    invoke-virtual {p0, v3}, Landroid/support/v4/widget/a;->c(I)Landroid/support/v4/widget/a;

    .line 224
    const/16 v3, 0x1f4

    invoke-virtual {p0, v3}, Landroid/support/v4/widget/a;->f(I)Landroid/support/v4/widget/a;

    .line 225
    invoke-virtual {p0, v3}, Landroid/support/v4/widget/a;->e(I)Landroid/support/v4/widget/a;

    .line 226
    return-void

    :array_0
    .array-data 4
        0x0
        0x0
    .end array-data

    :array_1
    .array-data 4
        0x7f7fffff    # Float.MAX_VALUE
        0x7f7fffff    # Float.MAX_VALUE
    .end array-data

    :array_2
    .array-data 4
        0x0
        0x0
    .end array-data

    :array_3
    .array-data 4
        0x0
        0x0
    .end array-data

    :array_4
    .array-data 4
        0x7f7fffff    # Float.MAX_VALUE
        0x7f7fffff    # Float.MAX_VALUE
    .end array-data
.end method

.method static a(FFF)F
    .locals 1
    .param p0, "value"    # F
    .param p1, "min"    # F
    .param p2, "max"    # F

    .line 673
    cmpl-float v0, p0, p2

    if-lez v0, :cond_0

    .line 674
    return p2

    .line 675
    :cond_0
    cmpg-float v0, p0, p1

    if-gez v0, :cond_1

    .line 676
    return p1

    .line 678
    :cond_1
    return p0
.end method

.method private a(FFFF)F
    .locals 7
    .param p1, "relativeValue"    # F
    .param p2, "size"    # F
    .param p3, "maxValue"    # F
    .param p4, "current"    # F

    .line 617
    mul-float v0, p1, p2

    const/4 v1, 0x0

    invoke-static {v0, v1, p3}, Landroid/support/v4/widget/a;->a(FFF)F

    move-result v0

    .line 618
    .local v0, "edgeSize":F
    invoke-direct {p0, p4, v0}, Landroid/support/v4/widget/a;->f(FF)F

    move-result v2

    .line 619
    .local v2, "valueLeading":F
    sub-float v3, p2, p4

    invoke-direct {p0, v3, v0}, Landroid/support/v4/widget/a;->f(FF)F

    move-result v3

    .line 620
    .local v3, "valueTrailing":F
    sub-float v4, v3, v2

    .line 622
    .local v4, "value":F
    cmpg-float v5, v4, v1

    if-gez v5, :cond_0

    .line 623
    iget-object v1, p0, Landroid/support/v4/widget/a;->c:Landroid/view/animation/Interpolator;

    neg-float v5, v4

    invoke-interface {v1, v5}, Landroid/view/animation/Interpolator;->getInterpolation(F)F

    move-result v1

    neg-float v1, v1

    .local v1, "interpolated":F
    goto :goto_0

    .line 624
    .end local v1    # "interpolated":F
    :cond_0
    cmpl-float v5, v4, v1

    if-lez v5, :cond_1

    .line 625
    iget-object v1, p0, Landroid/support/v4/widget/a;->c:Landroid/view/animation/Interpolator;

    invoke-interface {v1, v4}, Landroid/view/animation/Interpolator;->getInterpolation(F)F

    move-result v1

    .line 630
    .restart local v1    # "interpolated":F
    :goto_0
    const/high16 v5, -0x40800000    # -1.0f

    const/high16 v6, 0x3f800000    # 1.0f

    invoke-static {v1, v5, v6}, Landroid/support/v4/widget/a;->a(FFF)F

    move-result v5

    return v5

    .line 627
    .end local v1    # "interpolated":F
    :cond_1
    return v1
.end method

.method private a(IFFF)F
    .locals 8
    .param p1, "direction"    # I
    .param p2, "coordinate"    # F
    .param p3, "srcSize"    # F
    .param p4, "dstSize"    # F

    .line 549
    iget-object v0, p0, Landroid/support/v4/widget/a;->f:[F

    aget v0, v0, p1

    .line 550
    .local v0, "relativeEdge":F
    iget-object v1, p0, Landroid/support/v4/widget/a;->g:[F

    aget v1, v1, p1

    .line 551
    .local v1, "maximumEdge":F
    invoke-direct {p0, v0, p3, v1, p2}, Landroid/support/v4/widget/a;->a(FFFF)F

    move-result v2

    .line 552
    .local v2, "value":F
    const/4 v3, 0x0

    cmpl-float v4, v2, v3

    if-nez v4, :cond_0

    .line 554
    return v3

    .line 557
    :cond_0
    iget-object v4, p0, Landroid/support/v4/widget/a;->j:[F

    aget v4, v4, p1

    .line 558
    .local v4, "relativeVelocity":F
    iget-object v5, p0, Landroid/support/v4/widget/a;->k:[F

    aget v5, v5, p1

    .line 559
    .local v5, "minimumVelocity":F
    iget-object v6, p0, Landroid/support/v4/widget/a;->l:[F

    aget v6, v6, p1

    .line 560
    .local v6, "maximumVelocity":F
    mul-float v7, v4, p4

    .line 565
    .local v7, "targetVelocity":F
    cmpl-float v3, v2, v3

    if-lez v3, :cond_1

    .line 566
    mul-float v3, v2, v7

    invoke-static {v3, v5, v6}, Landroid/support/v4/widget/a;->a(FFF)F

    move-result v3

    return v3

    .line 568
    :cond_1
    neg-float v3, v2

    mul-float v3, v3, v7

    invoke-static {v3, v5, v6}, Landroid/support/v4/widget/a;->a(FFF)F

    move-result v3

    neg-float v3, v3

    return v3
.end method

.method static a(III)I
    .locals 0
    .param p0, "value"    # I
    .param p1, "min"    # I
    .param p2, "max"    # I

    .line 663
    if-le p0, p2, :cond_0

    .line 664
    return p2

    .line 665
    :cond_0
    if-ge p0, p1, :cond_1

    .line 666
    return p1

    .line 668
    :cond_1
    return p0
.end method

.method private c()V
    .locals 1

    .line 538
    iget-boolean v0, p0, Landroid/support/v4/widget/a;->n:Z

    if-eqz v0, :cond_0

    .line 541
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/widget/a;->p:Z

    goto :goto_0

    .line 543
    :cond_0
    iget-object v0, p0, Landroid/support/v4/widget/a;->b:Landroid/support/v4/widget/a$a;

    invoke-virtual {v0}, Landroid/support/v4/widget/a$a;->g()V

    .line 545
    :goto_0
    return-void
.end method

.method private d()V
    .locals 6

    .line 514
    iget-object v0, p0, Landroid/support/v4/widget/a;->e:Ljava/lang/Runnable;

    if-nez v0, :cond_0

    .line 515
    new-instance v0, Landroid/support/v4/widget/a$b;

    invoke-direct {v0, p0}, Landroid/support/v4/widget/a$b;-><init>(Landroid/support/v4/widget/a;)V

    iput-object v0, p0, Landroid/support/v4/widget/a;->e:Ljava/lang/Runnable;

    .line 518
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/widget/a;->p:Z

    .line 519
    iput-boolean v0, p0, Landroid/support/v4/widget/a;->n:Z

    .line 521
    iget-boolean v1, p0, Landroid/support/v4/widget/a;->m:Z

    if-nez v1, :cond_1

    iget v1, p0, Landroid/support/v4/widget/a;->i:I

    if-lez v1, :cond_1

    .line 522
    iget-object v2, p0, Landroid/support/v4/widget/a;->d:Landroid/view/View;

    iget-object v3, p0, Landroid/support/v4/widget/a;->e:Ljava/lang/Runnable;

    int-to-long v4, v1

    invoke-static {v2, v3, v4, v5}, La/b/c/g/u;->a(Landroid/view/View;Ljava/lang/Runnable;J)V

    goto :goto_0

    .line 524
    :cond_1
    iget-object v1, p0, Landroid/support/v4/widget/a;->e:Ljava/lang/Runnable;

    invoke-interface {v1}, Ljava/lang/Runnable;->run()V

    .line 529
    :goto_0
    iput-boolean v0, p0, Landroid/support/v4/widget/a;->m:Z

    .line 530
    return-void
.end method

.method private f(FF)F
    .locals 4
    .param p1, "current"    # F
    .param p2, "leading"    # F

    .line 634
    const/4 v0, 0x0

    cmpl-float v1, p2, v0

    if-nez v1, :cond_0

    .line 635
    return v0

    .line 638
    :cond_0
    iget v1, p0, Landroid/support/v4/widget/a;->h:I

    const/4 v2, 0x1

    if-eqz v1, :cond_2

    if-eq v1, v2, :cond_2

    const/4 v2, 0x2

    if-eq v1, v2, :cond_1

    goto :goto_0

    .line 652
    :cond_1
    cmpg-float v1, p1, v0

    if-gez v1, :cond_4

    .line 654
    neg-float v0, p2

    div-float v0, p1, v0

    return v0

    .line 641
    :cond_2
    cmpg-float v1, p1, p2

    if-gez v1, :cond_4

    .line 642
    const/high16 v1, 0x3f800000    # 1.0f

    cmpl-float v3, p1, v0

    if-ltz v3, :cond_3

    .line 644
    div-float v0, p1, p2

    sub-float/2addr v1, v0

    return v1

    .line 645
    :cond_3
    iget-boolean v3, p0, Landroid/support/v4/widget/a;->p:Z

    if-eqz v3, :cond_4

    iget v3, p0, Landroid/support/v4/widget/a;->h:I

    if-ne v3, v2, :cond_4

    .line 647
    return v1

    .line 659
    :cond_4
    :goto_0
    return v0
.end method


# virtual methods
.method public a(FF)Landroid/support/v4/widget/a;
    .locals 2
    .param p1, "horizontalMax"    # F
    .param p2, "verticalMax"    # F

    .line 402
    iget-object v0, p0, Landroid/support/v4/widget/a;->g:[F

    const/4 v1, 0x0

    aput p1, v0, v1

    .line 403
    const/4 v1, 0x1

    aput p2, v0, v1

    .line 404
    return-object p0
.end method

.method public a(Z)Landroid/support/v4/widget/a;
    .locals 1
    .param p1, "enabled"    # Z

    .line 236
    iget-boolean v0, p0, Landroid/support/v4/widget/a;->q:Z

    if-eqz v0, :cond_0

    if-nez p1, :cond_0

    .line 237
    invoke-direct {p0}, Landroid/support/v4/widget/a;->c()V

    .line 240
    :cond_0
    iput-boolean p1, p0, Landroid/support/v4/widget/a;->q:Z

    .line 241
    return-object p0
.end method

.method a()V
    .locals 10

    .line 687
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v8

    .line 688
    .local v8, "eventTime":J
    const/4 v4, 0x3

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-wide v0, v8

    move-wide v2, v8

    invoke-static/range {v0 .. v7}, Landroid/view/MotionEvent;->obtain(JJIFFI)Landroid/view/MotionEvent;

    move-result-object v0

    .line 690
    .local v0, "cancel":Landroid/view/MotionEvent;
    iget-object v1, p0, Landroid/support/v4/widget/a;->d:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 691
    invoke-virtual {v0}, Landroid/view/MotionEvent;->recycle()V

    .line 692
    return-void
.end method

.method public abstract a(II)V
.end method

.method public abstract a(I)Z
.end method

.method public b(FF)Landroid/support/v4/widget/a;
    .locals 4
    .param p1, "horizontalMax"    # F
    .param p2, "verticalMax"    # F

    .line 296
    iget-object v0, p0, Landroid/support/v4/widget/a;->l:[F

    const/high16 v1, 0x447a0000    # 1000.0f

    div-float v2, p1, v1

    const/4 v3, 0x0

    aput v2, v0, v3

    .line 297
    div-float v1, p2, v1

    const/4 v2, 0x1

    aput v1, v0, v2

    .line 298
    return-object p0
.end method

.method b()Z
    .locals 4

    .line 502
    iget-object v0, p0, Landroid/support/v4/widget/a;->b:Landroid/support/v4/widget/a$a;

    .line 503
    .local v0, "scroller":Landroid/support/v4/widget/a$a;
    invoke-virtual {v0}, Landroid/support/v4/widget/a$a;->e()I

    move-result v1

    .line 504
    .local v1, "verticalDirection":I
    invoke-virtual {v0}, Landroid/support/v4/widget/a$a;->d()I

    move-result v2

    .line 506
    .local v2, "horizontalDirection":I
    if-eqz v1, :cond_0

    invoke-virtual {p0, v1}, Landroid/support/v4/widget/a;->b(I)Z

    move-result v3

    if-nez v3, :cond_1

    :cond_0
    if-eqz v2, :cond_2

    .line 507
    invoke-virtual {p0, v2}, Landroid/support/v4/widget/a;->a(I)Z

    move-result v3

    if-eqz v3, :cond_2

    :cond_1
    const/4 v3, 0x1

    goto :goto_0

    :cond_2
    const/4 v3, 0x0

    :goto_0
    return v3
.end method

.method public abstract b(I)Z
.end method

.method public c(FF)Landroid/support/v4/widget/a;
    .locals 4
    .param p1, "horizontalMin"    # F
    .param p2, "verticalMin"    # F

    .line 315
    iget-object v0, p0, Landroid/support/v4/widget/a;->k:[F

    const/high16 v1, 0x447a0000    # 1000.0f

    div-float v2, p1, v1

    const/4 v3, 0x0

    aput v2, v0, v3

    .line 316
    div-float v1, p2, v1

    const/4 v2, 0x1

    aput v1, v0, v2

    .line 317
    return-object p0
.end method

.method public c(I)Landroid/support/v4/widget/a;
    .locals 0
    .param p1, "delayMillis"    # I

    .line 420
    iput p1, p0, Landroid/support/v4/widget/a;->i:I

    .line 421
    return-object p0
.end method

.method public d(FF)Landroid/support/v4/widget/a;
    .locals 2
    .param p1, "horizontal"    # F
    .param p2, "vertical"    # F

    .line 379
    iget-object v0, p0, Landroid/support/v4/widget/a;->f:[F

    const/4 v1, 0x0

    aput p1, v0, v1

    .line 380
    const/4 v1, 0x1

    aput p2, v0, v1

    .line 381
    return-object p0
.end method

.method public d(I)Landroid/support/v4/widget/a;
    .locals 0
    .param p1, "type"    # I

    .line 359
    iput p1, p0, Landroid/support/v4/widget/a;->h:I

    .line 360
    return-object p0
.end method

.method public e(FF)Landroid/support/v4/widget/a;
    .locals 4
    .param p1, "horizontal"    # F
    .param p2, "vertical"    # F

    .line 337
    iget-object v0, p0, Landroid/support/v4/widget/a;->j:[F

    const/high16 v1, 0x447a0000    # 1000.0f

    div-float v2, p1, v1

    const/4 v3, 0x0

    aput v2, v0, v3

    .line 338
    div-float v1, p2, v1

    const/4 v2, 0x1

    aput v1, v0, v2

    .line 339
    return-object p0
.end method

.method public e(I)Landroid/support/v4/widget/a;
    .locals 1
    .param p1, "durationMillis"    # I

    .line 452
    iget-object v0, p0, Landroid/support/v4/widget/a;->b:Landroid/support/v4/widget/a$a;

    invoke-virtual {v0, p1}, Landroid/support/v4/widget/a$a;->a(I)V

    .line 453
    return-object p0
.end method

.method public f(I)Landroid/support/v4/widget/a;
    .locals 1
    .param p1, "durationMillis"    # I

    .line 436
    iget-object v0, p0, Landroid/support/v4/widget/a;->b:Landroid/support/v4/widget/a$a;

    invoke-virtual {v0, p1}, Landroid/support/v4/widget/a$a;->b(I)V

    .line 437
    return-object p0
.end method

.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 7
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .line 466
    iget-boolean v0, p0, Landroid/support/v4/widget/a;->q:Z

    const/4 v1, 0x0

    if-nez v0, :cond_0

    .line 467
    return v1

    .line 470
    :cond_0
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    .line 471
    .local v0, "action":I
    const/4 v2, 0x1

    if-eqz v0, :cond_2

    if-eq v0, v2, :cond_1

    const/4 v3, 0x2

    if-eq v0, v3, :cond_3

    const/4 v3, 0x3

    if-eq v0, v3, :cond_1

    goto :goto_0

    .line 491
    :cond_1
    invoke-direct {p0}, Landroid/support/v4/widget/a;->c()V

    goto :goto_0

    .line 473
    :cond_2
    iput-boolean v2, p0, Landroid/support/v4/widget/a;->o:Z

    .line 474
    iput-boolean v1, p0, Landroid/support/v4/widget/a;->m:Z

    .line 477
    :cond_3
    nop

    .line 478
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v4

    int-to-float v4, v4

    iget-object v5, p0, Landroid/support/v4/widget/a;->d:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getWidth()I

    move-result v5

    int-to-float v5, v5

    .line 477
    invoke-direct {p0, v1, v3, v4, v5}, Landroid/support/v4/widget/a;->a(IFFF)F

    move-result v3

    .line 479
    .local v3, "xTargetVelocity":F
    nop

    .line 480
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result v5

    int-to-float v5, v5

    iget-object v6, p0, Landroid/support/v4/widget/a;->d:Landroid/view/View;

    invoke-virtual {v6}, Landroid/view/View;->getHeight()I

    move-result v6

    int-to-float v6, v6

    .line 479
    invoke-direct {p0, v2, v4, v5, v6}, Landroid/support/v4/widget/a;->a(IFFF)F

    move-result v4

    .line 481
    .local v4, "yTargetVelocity":F
    iget-object v5, p0, Landroid/support/v4/widget/a;->b:Landroid/support/v4/widget/a$a;

    invoke-virtual {v5, v3, v4}, Landroid/support/v4/widget/a$a;->a(FF)V

    .line 485
    iget-boolean v5, p0, Landroid/support/v4/widget/a;->p:Z

    if-nez v5, :cond_4

    invoke-virtual {p0}, Landroid/support/v4/widget/a;->b()Z

    move-result v5

    if-eqz v5, :cond_4

    .line 486
    invoke-direct {p0}, Landroid/support/v4/widget/a;->d()V

    .line 495
    .end local v3    # "xTargetVelocity":F
    .end local v4    # "yTargetVelocity":F
    :cond_4
    :goto_0
    iget-boolean v3, p0, Landroid/support/v4/widget/a;->r:Z

    if-eqz v3, :cond_5

    iget-boolean v3, p0, Landroid/support/v4/widget/a;->p:Z

    if-eqz v3, :cond_5

    const/4 v1, 0x1

    :cond_5
    return v1
.end method
