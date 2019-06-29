.class public La/b/d/d/i;
.super Ljava/lang/Object;
.source ""


# instance fields
.field final a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "La/b/c/g/A;",
            ">;"
        }
    .end annotation
.end field

.field private b:J

.field private c:Landroid/view/animation/Interpolator;

.field d:La/b/c/g/B;

.field private e:Z

.field private final f:La/b/c/g/C;


# direct methods
.method public constructor <init>()V
    .locals 2

    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    const-wide/16 v0, -0x1

    iput-wide v0, p0, La/b/d/d/i;->b:J

    .line 120
    new-instance v0, La/b/d/d/h;

    invoke-direct {v0, p0}, La/b/d/d/h;-><init>(La/b/d/d/i;)V

    iput-object v0, p0, La/b/d/d/i;->f:La/b/c/g/C;

    .line 49
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, La/b/d/d/i;->a:Ljava/util/ArrayList;

    .line 50
    return-void
.end method


# virtual methods
.method public a(J)La/b/d/d/i;
    .locals 1
    .param p1, "duration"    # J

    .line 100
    iget-boolean v0, p0, La/b/d/d/i;->e:Z

    if-nez v0, :cond_0

    .line 101
    iput-wide p1, p0, La/b/d/d/i;->b:J

    .line 103
    :cond_0
    return-object p0
.end method

.method public a(La/b/c/g/A;)La/b/d/d/i;
    .locals 1
    .param p1, "animator"    # La/b/c/g/A;

    .line 53
    iget-boolean v0, p0, La/b/d/d/i;->e:Z

    if-nez v0, :cond_0

    .line 54
    iget-object v0, p0, La/b/d/d/i;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 56
    :cond_0
    return-object p0
.end method

.method public a(La/b/c/g/A;La/b/c/g/A;)La/b/d/d/i;
    .locals 2
    .param p1, "anim1"    # La/b/c/g/A;
    .param p2, "anim2"    # La/b/c/g/A;

    .line 61
    iget-object v0, p0, La/b/d/d/i;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 62
    invoke-virtual {p1}, La/b/c/g/A;->b()J

    move-result-wide v0

    invoke-virtual {p2, v0, v1}, La/b/c/g/A;->b(J)La/b/c/g/A;

    .line 63
    iget-object v0, p0, La/b/d/d/i;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 64
    return-object p0
.end method

.method public a(La/b/c/g/B;)La/b/d/d/i;
    .locals 1
    .param p1, "listener"    # La/b/c/g/B;

    .line 114
    iget-boolean v0, p0, La/b/d/d/i;->e:Z

    if-nez v0, :cond_0

    .line 115
    iput-object p1, p0, La/b/d/d/i;->d:La/b/c/g/B;

    .line 117
    :cond_0
    return-object p0
.end method

.method public a(Landroid/view/animation/Interpolator;)La/b/d/d/i;
    .locals 1
    .param p1, "interpolator"    # Landroid/view/animation/Interpolator;

    .line 107
    iget-boolean v0, p0, La/b/d/d/i;->e:Z

    if-nez v0, :cond_0

    .line 108
    iput-object p1, p0, La/b/d/d/i;->c:Landroid/view/animation/Interpolator;

    .line 110
    :cond_0
    return-object p0
.end method

.method public a()V
    .locals 2

    .line 90
    iget-boolean v0, p0, La/b/d/d/i;->e:Z

    if-nez v0, :cond_0

    .line 91
    return-void

    .line 93
    :cond_0
    iget-object v0, p0, La/b/d/d/i;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, La/b/c/g/A;

    .line 94
    .local v1, "animator":La/b/c/g/A;
    invoke-virtual {v1}, La/b/c/g/A;->a()V

    .line 95
    .end local v1    # "animator":La/b/c/g/A;
    goto :goto_0

    .line 96
    :cond_1
    const/4 v0, 0x0

    iput-boolean v0, p0, La/b/d/d/i;->e:Z

    .line 97
    return-void
.end method

.method b()V
    .locals 1

    .line 86
    const/4 v0, 0x0

    iput-boolean v0, p0, La/b/d/d/i;->e:Z

    .line 87
    return-void
.end method

.method public c()V
    .locals 7

    .line 68
    iget-boolean v0, p0, La/b/d/d/i;->e:Z

    if-eqz v0, :cond_0

    return-void

    .line 69
    :cond_0
    iget-object v0, p0, La/b/d/d/i;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_4

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, La/b/c/g/A;

    .line 70
    .local v1, "animator":La/b/c/g/A;
    iget-wide v2, p0, La/b/d/d/i;->b:J

    const-wide/16 v4, 0x0

    cmp-long v6, v2, v4

    if-ltz v6, :cond_1

    .line 71
    invoke-virtual {v1, v2, v3}, La/b/c/g/A;->a(J)La/b/c/g/A;

    .line 73
    :cond_1
    iget-object v2, p0, La/b/d/d/i;->c:Landroid/view/animation/Interpolator;

    if-eqz v2, :cond_2

    .line 74
    invoke-virtual {v1, v2}, La/b/c/g/A;->a(Landroid/view/animation/Interpolator;)La/b/c/g/A;

    .line 76
    :cond_2
    iget-object v2, p0, La/b/d/d/i;->d:La/b/c/g/B;

    if-eqz v2, :cond_3

    .line 77
    iget-object v2, p0, La/b/d/d/i;->f:La/b/c/g/C;

    invoke-virtual {v1, v2}, La/b/c/g/A;->a(La/b/c/g/B;)La/b/c/g/A;

    .line 79
    :cond_3
    invoke-virtual {v1}, La/b/c/g/A;->c()V

    .line 80
    .end local v1    # "animator":La/b/c/g/A;
    goto :goto_0

    .line 82
    :cond_4
    const/4 v0, 0x1

    iput-boolean v0, p0, La/b/d/d/i;->e:Z

    .line 83
    return-void
.end method
