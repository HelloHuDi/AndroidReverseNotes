.class La/b/c/f/c;
.super La/b/c/f/j;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = La/b/c/f/d;->a()La/b/c/f/j;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "La/b/c/f/j<",
        "TE;TE;>;"
    }
.end annotation


# instance fields
.field final synthetic d:La/b/c/f/d;


# direct methods
.method constructor <init>(La/b/c/f/d;)V
    .locals 0
    .param p1, "this$0"    # La/b/c/f/d;

    .line 667
    .local p0, "this":La/b/c/f/c;, "Landroid/support/v4/util/ArraySet$1;"
    iput-object p1, p0, La/b/c/f/c;->d:La/b/c/f/d;

    invoke-direct {p0}, La/b/c/f/j;-><init>()V

    return-void
.end method


# virtual methods
.method protected a(Ljava/lang/Object;)I
    .locals 1
    .param p1, "key"    # Ljava/lang/Object;

    .line 680
    .local p0, "this":La/b/c/f/c;, "Landroid/support/v4/util/ArraySet$1;"
    iget-object v0, p0, La/b/c/f/c;->d:La/b/c/f/d;

    invoke-virtual {v0, p1}, La/b/c/f/d;->indexOf(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method protected a(II)Ljava/lang/Object;
    .locals 1
    .param p1, "index"    # I
    .param p2, "offset"    # I

    .line 675
    .local p0, "this":La/b/c/f/c;, "Landroid/support/v4/util/ArraySet$1;"
    iget-object v0, p0, La/b/c/f/c;->d:La/b/c/f/d;

    iget-object v0, v0, La/b/c/f/d;->h:[Ljava/lang/Object;

    aget-object v0, v0, p1

    return-object v0
.end method

.method protected a(ILjava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(ITE;)TE;"
        }
    .end annotation

    .line 700
    .local p0, "this":La/b/c/f/c;, "Landroid/support/v4/util/ArraySet$1;"
    .local p2, "value":Ljava/lang/Object;, "TE;"
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "not a map"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected a()V
    .locals 1

    .line 710
    .local p0, "this":La/b/c/f/c;, "Landroid/support/v4/util/ArraySet$1;"
    iget-object v0, p0, La/b/c/f/c;->d:La/b/c/f/d;

    invoke-virtual {v0}, La/b/c/f/d;->clear()V

    .line 711
    return-void
.end method

.method protected a(I)V
    .locals 1
    .param p1, "index"    # I

    .line 705
    .local p0, "this":La/b/c/f/c;, "Landroid/support/v4/util/ArraySet$1;"
    iget-object v0, p0, La/b/c/f/c;->d:La/b/c/f/d;

    invoke-virtual {v0, p1}, La/b/c/f/d;->b(I)Ljava/lang/Object;

    .line 706
    return-void
.end method

.method protected a(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;TE;)V"
        }
    .end annotation

    .line 695
    .local p0, "this":La/b/c/f/c;, "Landroid/support/v4/util/ArraySet$1;"
    .local p1, "key":Ljava/lang/Object;, "TE;"
    .local p2, "value":Ljava/lang/Object;, "TE;"
    iget-object v0, p0, La/b/c/f/c;->d:La/b/c/f/d;

    invoke-virtual {v0, p1}, La/b/c/f/d;->add(Ljava/lang/Object;)Z

    .line 696
    return-void
.end method

.method protected b(Ljava/lang/Object;)I
    .locals 1
    .param p1, "value"    # Ljava/lang/Object;

    .line 685
    .local p0, "this":La/b/c/f/c;, "Landroid/support/v4/util/ArraySet$1;"
    iget-object v0, p0, La/b/c/f/c;->d:La/b/c/f/d;

    invoke-virtual {v0, p1}, La/b/c/f/d;->indexOf(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method protected b()Ljava/util/Map;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "TE;TE;>;"
        }
    .end annotation

    .line 690
    .local p0, "this":La/b/c/f/c;, "Landroid/support/v4/util/ArraySet$1;"
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "not a map"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected c()I
    .locals 1

    .line 670
    .local p0, "this":La/b/c/f/c;, "Landroid/support/v4/util/ArraySet$1;"
    iget-object v0, p0, La/b/c/f/c;->d:La/b/c/f/d;

    iget v0, v0, La/b/c/f/d;->i:I

    return v0
.end method
