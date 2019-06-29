.class Landroid/support/v4/widget/a$a;
.super Ljava/lang/Object;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/widget/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "a"
.end annotation


# instance fields
.field private a:I

.field private b:I

.field private c:F

.field private d:F

.field private e:J

.field private f:J

.field private g:I

.field private h:I

.field private i:J

.field private j:F

.field private k:I


# direct methods
.method constructor <init>()V
    .locals 2

    .line 756
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 757
    const-wide/high16 v0, -0x8000000000000000L

    iput-wide v0, p0, Landroid/support/v4/widget/a$a;->e:J

    .line 758
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Landroid/support/v4/widget/a$a;->i:J

    .line 759
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroid/support/v4/widget/a$a;->f:J

    .line 760
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v4/widget/a$a;->g:I

    .line 761
    iput v0, p0, Landroid/support/v4/widget/a$a;->h:I

    .line 762
    return-void
.end method

.method private a(F)F
    .locals 2
    .param p1, "value"    # F

    .line 820
    const/high16 v0, -0x3f800000    # -4.0f

    mul-float v0, v0, p1

    mul-float v0, v0, p1

    const/high16 v1, 0x40800000    # 4.0f

    mul-float v1, v1, p1

    add-float/2addr v0, v1

    return v0
.end method

.method private a(J)F
    .locals 8
    .param p1, "currentTime"    # J

    .line 800
    iget-wide v0, p0, Landroid/support/v4/widget/a$a;->e:J

    const/4 v2, 0x0

    cmp-long v3, p1, v0

    if-gez v3, :cond_0

    .line 801
    return v2

    .line 802
    :cond_0
    iget-wide v0, p0, Landroid/support/v4/widget/a$a;->i:J

    const-wide/16 v3, 0x0

    const/high16 v5, 0x3f800000    # 1.0f

    cmp-long v6, v0, v3

    if-ltz v6, :cond_2

    cmp-long v3, p1, v0

    if-gez v3, :cond_1

    goto :goto_0

    .line 806
    :cond_1
    sub-long v0, p1, v0

    .line 807
    .local v0, "elapsedSinceEnd":J
    iget v3, p0, Landroid/support/v4/widget/a$a;->j:F

    sub-float v4, v5, v3

    long-to-float v6, v0

    iget v7, p0, Landroid/support/v4/widget/a$a;->k:I

    int-to-float v7, v7

    div-float/2addr v6, v7

    .line 808
    invoke-static {v6, v2, v5}, Landroid/support/v4/widget/a;->a(FFF)F

    move-result v2

    mul-float v3, v3, v2

    add-float/2addr v4, v3

    return v4

    .line 803
    .end local v0    # "elapsedSinceEnd":J
    :cond_2
    :goto_0
    iget-wide v0, p0, Landroid/support/v4/widget/a$a;->e:J

    sub-long v0, p1, v0

    .line 804
    .local v0, "elapsedSinceStart":J
    const/high16 v3, 0x3f000000    # 0.5f

    long-to-float v4, v0

    iget v6, p0, Landroid/support/v4/widget/a$a;->a:I

    int-to-float v6, v6

    div-float/2addr v4, v6

    invoke-static {v4, v2, v5}, Landroid/support/v4/widget/a;->a(FFF)F

    move-result v2

    mul-float v2, v2, v3

    return v2
.end method


# virtual methods
.method public a()V
    .locals 8

    .line 831
    iget-wide v0, p0, Landroid/support/v4/widget/a$a;->f:J

    const-wide/16 v2, 0x0

    cmp-long v4, v0, v2

    if-eqz v4, :cond_0

    .line 835
    invoke-static {}, Landroid/view/animation/AnimationUtils;->currentAnimationTimeMillis()J

    move-result-wide v0

    .line 836
    .local v0, "currentTime":J
    invoke-direct {p0, v0, v1}, Landroid/support/v4/widget/a$a;->a(J)F

    move-result v2

    .line 837
    .local v2, "value":F
    invoke-direct {p0, v2}, Landroid/support/v4/widget/a$a;->a(F)F

    move-result v3

    .line 838
    .local v3, "scale":F
    iget-wide v4, p0, Landroid/support/v4/widget/a$a;->f:J

    sub-long v4, v0, v4

    .line 840
    .local v4, "elapsedSinceDelta":J
    iput-wide v0, p0, Landroid/support/v4/widget/a$a;->f:J

    .line 841
    long-to-float v6, v4

    mul-float v6, v6, v3

    iget v7, p0, Landroid/support/v4/widget/a$a;->c:F

    mul-float v6, v6, v7

    float-to-int v6, v6

    iput v6, p0, Landroid/support/v4/widget/a$a;->g:I

    .line 842
    long-to-float v6, v4

    mul-float v6, v6, v3

    iget v7, p0, Landroid/support/v4/widget/a$a;->d:F

    mul-float v6, v6, v7

    float-to-int v6, v6

    iput v6, p0, Landroid/support/v4/widget/a$a;->h:I

    .line 843
    return-void

    .line 832
    .end local v0    # "currentTime":J
    .end local v2    # "value":F
    .end local v3    # "scale":F
    .end local v4    # "elapsedSinceDelta":J
    :cond_0
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Cannot compute scroll delta before calling start()"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public a(FF)V
    .locals 0
    .param p1, "x"    # F
    .param p2, "y"    # F

    .line 852
    iput p1, p0, Landroid/support/v4/widget/a$a;->c:F

    .line 853
    iput p2, p0, Landroid/support/v4/widget/a$a;->d:F

    .line 854
    return-void
.end method

.method public a(I)V
    .locals 0
    .param p1, "durationMillis"    # I

    .line 769
    iput p1, p0, Landroid/support/v4/widget/a$a;->b:I

    .line 770
    return-void
.end method

.method public b()I
    .locals 1

    .line 869
    iget v0, p0, Landroid/support/v4/widget/a$a;->g:I

    return v0
.end method

.method public b(I)V
    .locals 0
    .param p1, "durationMillis"    # I

    .line 765
    iput p1, p0, Landroid/support/v4/widget/a$a;->a:I

    .line 766
    return-void
.end method

.method public c()I
    .locals 1

    .line 877
    iget v0, p0, Landroid/support/v4/widget/a$a;->h:I

    return v0
.end method

.method public d()I
    .locals 2

    .line 857
    iget v0, p0, Landroid/support/v4/widget/a$a;->c:F

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v1

    div-float/2addr v0, v1

    float-to-int v0, v0

    return v0
.end method

.method public e()I
    .locals 2

    .line 861
    iget v0, p0, Landroid/support/v4/widget/a$a;->d:F

    invoke-static {v0}, Ljava/lang/Math;->abs(F)F

    move-result v1

    div-float/2addr v0, v1

    float-to-int v0, v0

    return v0
.end method

.method public f()Z
    .locals 6

    .line 795
    iget-wide v0, p0, Landroid/support/v4/widget/a$a;->i:J

    const-wide/16 v2, 0x0

    cmp-long v4, v0, v2

    if-lez v4, :cond_0

    .line 796
    invoke-static {}, Landroid/view/animation/AnimationUtils;->currentAnimationTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Landroid/support/v4/widget/a$a;->i:J

    iget v4, p0, Landroid/support/v4/widget/a$a;->k:I

    int-to-long v4, v4

    add-long/2addr v2, v4

    cmp-long v4, v0, v2

    if-lez v4, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public g()V
    .locals 5

    .line 788
    invoke-static {}, Landroid/view/animation/AnimationUtils;->currentAnimationTimeMillis()J

    move-result-wide v0

    .line 789
    .local v0, "currentTime":J
    iget-wide v2, p0, Landroid/support/v4/widget/a$a;->e:J

    sub-long v2, v0, v2

    long-to-int v3, v2

    iget v2, p0, Landroid/support/v4/widget/a$a;->b:I

    const/4 v4, 0x0

    invoke-static {v3, v4, v2}, Landroid/support/v4/widget/a;->a(III)I

    move-result v2

    iput v2, p0, Landroid/support/v4/widget/a$a;->k:I

    .line 790
    invoke-direct {p0, v0, v1}, Landroid/support/v4/widget/a$a;->a(J)F

    move-result v2

    iput v2, p0, Landroid/support/v4/widget/a$a;->j:F

    .line 791
    iput-wide v0, p0, Landroid/support/v4/widget/a$a;->i:J

    .line 792
    return-void
.end method

.method public h()V
    .locals 2

    .line 776
    invoke-static {}, Landroid/view/animation/AnimationUtils;->currentAnimationTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Landroid/support/v4/widget/a$a;->e:J

    .line 777
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Landroid/support/v4/widget/a$a;->i:J

    .line 778
    iget-wide v0, p0, Landroid/support/v4/widget/a$a;->e:J

    iput-wide v0, p0, Landroid/support/v4/widget/a$a;->f:J

    .line 779
    const/high16 v0, 0x3f000000    # 0.5f

    iput v0, p0, Landroid/support/v4/widget/a$a;->j:F

    .line 780
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v4/widget/a$a;->g:I

    .line 781
    iput v0, p0, Landroid/support/v4/widget/a$a;->h:I

    .line 782
    return-void
.end method
