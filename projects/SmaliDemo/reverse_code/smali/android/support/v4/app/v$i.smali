.class Landroid/support/v4/app/v$i;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/support/v4/app/i$c;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/app/v;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "i"
.end annotation


# instance fields
.field final a:Z

.field final b:Landroid/support/v4/app/c;

.field private c:I


# direct methods
.method constructor <init>(Landroid/support/v4/app/c;Z)V
    .locals 0
    .param p1, "record"    # Landroid/support/v4/app/c;
    .param p2, "isBack"    # Z

    .line 3873
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3874
    iput-boolean p2, p0, Landroid/support/v4/app/v$i;->a:Z

    .line 3875
    iput-object p1, p0, Landroid/support/v4/app/v$i;->b:Landroid/support/v4/app/c;

    .line 3876
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .line 3899
    iget v0, p0, Landroid/support/v4/app/v$i;->c:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroid/support/v4/app/v$i;->c:I

    .line 3900
    return-void
.end method

.method public b()V
    .locals 1

    .line 3885
    iget v0, p0, Landroid/support/v4/app/v$i;->c:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Landroid/support/v4/app/v$i;->c:I

    .line 3886
    iget v0, p0, Landroid/support/v4/app/v$i;->c:I

    if-eqz v0, :cond_0

    .line 3887
    return-void

    .line 3889
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/v$i;->b:Landroid/support/v4/app/c;

    iget-object v0, v0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    invoke-virtual {v0}, Landroid/support/v4/app/v;->v()V

    .line 3890
    return-void
.end method

.method public c()V
    .locals 4

    .line 3934
    iget-object v0, p0, Landroid/support/v4/app/v$i;->b:Landroid/support/v4/app/c;

    iget-object v1, v0, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    iget-boolean v2, p0, Landroid/support/v4/app/v$i;->a:Z

    const/4 v3, 0x0

    invoke-virtual {v1, v0, v2, v3, v3}, Landroid/support/v4/app/v;->a(Landroid/support/v4/app/c;ZZZ)V

    .line 3935
    return-void
.end method

.method public d()V
    .locals 8

    .line 3916
    iget v0, p0, Landroid/support/v4/app/v$i;->c:I

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-lez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 3917
    .local v0, "canceled":Z
    :goto_0
    iget-object v3, p0, Landroid/support/v4/app/v$i;->b:Landroid/support/v4/app/c;

    iget-object v3, v3, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    .line 3918
    .local v3, "manager":Landroid/support/v4/app/v;
    iget-object v4, v3, Landroid/support/v4/app/v;->j:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    .line 3919
    .local v4, "numAdded":I
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_1
    if-ge v5, v4, :cond_2

    .line 3920
    iget-object v6, v3, Landroid/support/v4/app/v;->j:Ljava/util/ArrayList;

    invoke-virtual {v6, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/support/v4/app/i;

    .line 3921
    .local v6, "fragment":Landroid/support/v4/app/i;
    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Landroid/support/v4/app/i;->a(Landroid/support/v4/app/i$c;)V

    .line 3922
    if-eqz v0, :cond_1

    invoke-virtual {v6}, Landroid/support/v4/app/i;->D()Z

    move-result v7

    if-eqz v7, :cond_1

    .line 3923
    invoke-virtual {v6}, Landroid/support/v4/app/i;->Y()V

    .line 3919
    .end local v6    # "fragment":Landroid/support/v4/app/i;
    :cond_1
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .line 3926
    .end local v5    # "i":I
    :cond_2
    iget-object v5, p0, Landroid/support/v4/app/v$i;->b:Landroid/support/v4/app/c;

    iget-object v6, v5, Landroid/support/v4/app/c;->a:Landroid/support/v4/app/v;

    iget-boolean v7, p0, Landroid/support/v4/app/v$i;->a:Z

    if-nez v0, :cond_3

    const/4 v1, 0x1

    :cond_3
    invoke-virtual {v6, v5, v7, v1, v2}, Landroid/support/v4/app/v;->a(Landroid/support/v4/app/c;ZZZ)V

    .line 3927
    return-void
.end method

.method public e()Z
    .locals 1

    .line 3906
    iget v0, p0, Landroid/support/v4/app/v$i;->c:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method
