.class La/b/c/f/a;
.super La/b/c/f/j;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = La/b/c/f/b;->b()La/b/c/f/j;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "La/b/c/f/j<",
        "TK;TV;>;"
    }
.end annotation


# instance fields
.field final synthetic d:La/b/c/f/b;


# direct methods
.method constructor <init>(La/b/c/f/b;)V
    .locals 0
    .param p1, "this$0"    # La/b/c/f/b;

    .line 76
    .local p0, "this":La/b/c/f/a;, "Landroid/support/v4/util/ArrayMap$1;"
    iput-object p1, p0, La/b/c/f/a;->d:La/b/c/f/b;

    invoke-direct {p0}, La/b/c/f/j;-><init>()V

    return-void
.end method


# virtual methods
.method protected a(Ljava/lang/Object;)I
    .locals 1
    .param p1, "key"    # Ljava/lang/Object;

    .line 89
    .local p0, "this":La/b/c/f/a;, "Landroid/support/v4/util/ArrayMap$1;"
    iget-object v0, p0, La/b/c/f/a;->d:La/b/c/f/b;

    invoke-virtual {v0, p1}, La/b/c/f/m;->a(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method protected a(II)Ljava/lang/Object;
    .locals 2
    .param p1, "index"    # I
    .param p2, "offset"    # I

    .line 84
    .local p0, "this":La/b/c/f/a;, "Landroid/support/v4/util/ArrayMap$1;"
    iget-object v0, p0, La/b/c/f/a;->d:La/b/c/f/b;

    iget-object v0, v0, La/b/c/f/m;->f:[Ljava/lang/Object;

    shl-int/lit8 v1, p1, 0x1

    add-int/2addr v1, p2

    aget-object v0, v0, v1

    return-object v0
.end method

.method protected a(ILjava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(ITV;)TV;"
        }
    .end annotation

    .line 109
    .local p0, "this":La/b/c/f/a;, "Landroid/support/v4/util/ArrayMap$1;"
    .local p2, "value":Ljava/lang/Object;, "TV;"
    iget-object v0, p0, La/b/c/f/a;->d:La/b/c/f/b;

    invoke-virtual {v0, p1, p2}, La/b/c/f/m;->a(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method protected a()V
    .locals 1

    .line 119
    .local p0, "this":La/b/c/f/a;, "Landroid/support/v4/util/ArrayMap$1;"
    iget-object v0, p0, La/b/c/f/a;->d:La/b/c/f/b;

    invoke-virtual {v0}, La/b/c/f/m;->clear()V

    .line 120
    return-void
.end method

.method protected a(I)V
    .locals 1
    .param p1, "index"    # I

    .line 114
    .local p0, "this":La/b/c/f/a;, "Landroid/support/v4/util/ArrayMap$1;"
    iget-object v0, p0, La/b/c/f/a;->d:La/b/c/f/b;

    invoke-virtual {v0, p1}, La/b/c/f/m;->c(I)Ljava/lang/Object;

    .line 115
    return-void
.end method

.method protected a(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;TV;)V"
        }
    .end annotation

    .line 104
    .local p0, "this":La/b/c/f/a;, "Landroid/support/v4/util/ArrayMap$1;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    .local p2, "value":Ljava/lang/Object;, "TV;"
    iget-object v0, p0, La/b/c/f/a;->d:La/b/c/f/b;

    invoke-virtual {v0, p1, p2}, La/b/c/f/m;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 105
    return-void
.end method

.method protected b(Ljava/lang/Object;)I
    .locals 1
    .param p1, "value"    # Ljava/lang/Object;

    .line 94
    .local p0, "this":La/b/c/f/a;, "Landroid/support/v4/util/ArrayMap$1;"
    iget-object v0, p0, La/b/c/f/a;->d:La/b/c/f/b;

    invoke-virtual {v0, p1}, La/b/c/f/m;->b(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method protected b()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "TK;TV;>;"
        }
    .end annotation

    .line 99
    .local p0, "this":La/b/c/f/a;, "Landroid/support/v4/util/ArrayMap$1;"
    iget-object v0, p0, La/b/c/f/a;->d:La/b/c/f/b;

    return-object v0
.end method

.method protected c()I
    .locals 1

    .line 79
    .local p0, "this":La/b/c/f/a;, "Landroid/support/v4/util/ArrayMap$1;"
    iget-object v0, p0, La/b/c/f/a;->d:La/b/c/f/b;

    iget v0, v0, La/b/c/f/m;->g:I

    return v0
.end method
