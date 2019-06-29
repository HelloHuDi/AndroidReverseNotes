.class final La/b/c/f/j$d;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/util/Iterator;
.implements Ljava/util/Map$Entry;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/b/c/f/j;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "d"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Iterator<",
        "Ljava/util/Map$Entry<",
        "TK;TV;>;>;",
        "Ljava/util/Map$Entry<",
        "TK;TV;>;"
    }
.end annotation


# instance fields
.field a:I

.field b:I

.field c:Z

.field final synthetic d:La/b/c/f/j;


# direct methods
.method constructor <init>(La/b/c/f/j;)V
    .locals 1
    .param p1, "this$0"    # La/b/c/f/j;

    .line 79
    .local p0, "this":La/b/c/f/j$d;, "Landroid/support/v4/util/MapCollections<TK;TV;>.MapIterator;"
    iput-object p1, p0, La/b/c/f/j$d;->d:La/b/c/f/j;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 77
    const/4 v0, 0x0

    iput-boolean v0, p0, La/b/c/f/j$d;->c:Z

    .line 80
    invoke-virtual {p1}, La/b/c/f/j;->c()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, La/b/c/f/j$d;->a:I

    .line 81
    const/4 v0, -0x1

    iput v0, p0, La/b/c/f/j$d;->b:I

    .line 82
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 6
    .param p1, "o"    # Ljava/lang/Object;

    .line 137
    .local p0, "this":La/b/c/f/j$d;, "Landroid/support/v4/util/MapCollections<TK;TV;>.MapIterator;"
    iget-boolean v0, p0, La/b/c/f/j$d;->c:Z

    if-eqz v0, :cond_2

    .line 141
    instance-of v0, p1, Ljava/util/Map$Entry;

    const/4 v1, 0x0

    if-nez v0, :cond_0

    .line 142
    return v1

    .line 144
    :cond_0
    move-object v0, p1

    check-cast v0, Ljava/util/Map$Entry;

    .line 145
    .local v0, "e":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<**>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    iget-object v3, p0, La/b/c/f/j$d;->d:La/b/c/f/j;

    iget v4, p0, La/b/c/f/j$d;->b:I

    invoke-virtual {v3, v4, v1}, La/b/c/f/j;->a(II)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v2, v3}, La/b/c/f/e;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    const/4 v3, 0x1

    if-eqz v2, :cond_1

    .line 146
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v2

    iget-object v4, p0, La/b/c/f/j$d;->d:La/b/c/f/j;

    iget v5, p0, La/b/c/f/j$d;->b:I

    invoke-virtual {v4, v5, v3}, La/b/c/f/j;->a(II)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v2, v4}, La/b/c/f/e;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    const/4 v1, 0x1

    goto :goto_0

    :cond_1
    nop

    :goto_0
    return v1

    .line 138
    .end local v0    # "e":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<**>;"
    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "This container does not support retaining Map.Entry objects"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public getKey()Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TK;"
        }
    .end annotation

    .line 110
    .local p0, "this":La/b/c/f/j$d;, "Landroid/support/v4/util/MapCollections<TK;TV;>.MapIterator;"
    iget-boolean v0, p0, La/b/c/f/j$d;->c:Z

    if-eqz v0, :cond_0

    .line 114
    iget-object v0, p0, La/b/c/f/j$d;->d:La/b/c/f/j;

    iget v1, p0, La/b/c/f/j$d;->b:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, La/b/c/f/j;->a(II)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    .line 111
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "This container does not support retaining Map.Entry objects"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public getValue()Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TV;"
        }
    .end annotation

    .line 119
    .local p0, "this":La/b/c/f/j$d;, "Landroid/support/v4/util/MapCollections<TK;TV;>.MapIterator;"
    iget-boolean v0, p0, La/b/c/f/j$d;->c:Z

    if-eqz v0, :cond_0

    .line 123
    iget-object v0, p0, La/b/c/f/j$d;->d:La/b/c/f/j;

    iget v1, p0, La/b/c/f/j$d;->b:I

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, La/b/c/f/j;->a(II)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    .line 120
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "This container does not support retaining Map.Entry objects"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public hasNext()Z
    .locals 2

    .line 86
    .local p0, "this":La/b/c/f/j$d;, "Landroid/support/v4/util/MapCollections<TK;TV;>.MapIterator;"
    iget v0, p0, La/b/c/f/j$d;->b:I

    iget v1, p0, La/b/c/f/j$d;->a:I

    if-ge v0, v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public hashCode()I
    .locals 5

    .line 151
    .local p0, "this":La/b/c/f/j$d;, "Landroid/support/v4/util/MapCollections<TK;TV;>.MapIterator;"
    iget-boolean v0, p0, La/b/c/f/j$d;->c:Z

    if-eqz v0, :cond_2

    .line 155
    iget-object v0, p0, La/b/c/f/j$d;->d:La/b/c/f/j;

    iget v1, p0, La/b/c/f/j$d;->b:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, La/b/c/f/j;->a(II)Ljava/lang/Object;

    move-result-object v0

    .line 156
    .local v0, "key":Ljava/lang/Object;
    iget-object v1, p0, La/b/c/f/j$d;->d:La/b/c/f/j;

    iget v3, p0, La/b/c/f/j$d;->b:I

    const/4 v4, 0x1

    invoke-virtual {v1, v3, v4}, La/b/c/f/j;->a(II)Ljava/lang/Object;

    move-result-object v1

    .line 157
    .local v1, "value":Ljava/lang/Object;
    if-nez v0, :cond_0

    const/4 v3, 0x0

    goto :goto_0

    :cond_0
    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v3

    :goto_0
    if-nez v1, :cond_1

    goto :goto_1

    .line 158
    :cond_1
    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v2

    :goto_1
    xor-int/2addr v2, v3

    return v2

    .line 152
    .end local v0    # "key":Ljava/lang/Object;
    .end local v1    # "value":Ljava/lang/Object;
    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "This container does not support retaining Map.Entry objects"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public bridge synthetic next()Ljava/lang/Object;
    .locals 0

    .line 74
    .local p0, "this":La/b/c/f/j$d;, "Landroid/support/v4/util/MapCollections<TK;TV;>.MapIterator;"
    invoke-virtual {p0}, La/b/c/f/j$d;->next()Ljava/util/Map$Entry;

    return-object p0
.end method

.method public next()Ljava/util/Map$Entry;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map$Entry<",
            "TK;TV;>;"
        }
    .end annotation

    .line 91
    .local p0, "this":La/b/c/f/j$d;, "Landroid/support/v4/util/MapCollections<TK;TV;>.MapIterator;"
    invoke-virtual {p0}, La/b/c/f/j$d;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 92
    iget v0, p0, La/b/c/f/j$d;->b:I

    const/4 v1, 0x1

    add-int/2addr v0, v1

    iput v0, p0, La/b/c/f/j$d;->b:I

    .line 93
    iput-boolean v1, p0, La/b/c/f/j$d;->c:Z

    .line 94
    return-object p0

    .line 91
    :cond_0
    new-instance v0, Ljava/util/NoSuchElementException;

    invoke-direct {v0}, Ljava/util/NoSuchElementException;-><init>()V

    throw v0
.end method

.method public remove()V
    .locals 2

    .line 99
    .local p0, "this":La/b/c/f/j$d;, "Landroid/support/v4/util/MapCollections<TK;TV;>.MapIterator;"
    iget-boolean v0, p0, La/b/c/f/j$d;->c:Z

    if-eqz v0, :cond_0

    .line 102
    iget-object v0, p0, La/b/c/f/j$d;->d:La/b/c/f/j;

    iget v1, p0, La/b/c/f/j$d;->b:I

    invoke-virtual {v0, v1}, La/b/c/f/j;->a(I)V

    .line 103
    iget v0, p0, La/b/c/f/j$d;->b:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, La/b/c/f/j$d;->b:I

    .line 104
    iget v0, p0, La/b/c/f/j$d;->a:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, La/b/c/f/j$d;->a:I

    .line 105
    const/4 v0, 0x0

    iput-boolean v0, p0, La/b/c/f/j$d;->c:Z

    .line 106
    return-void

    .line 100
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0
.end method

.method public setValue(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TV;)TV;"
        }
    .end annotation

    .line 128
    .local p0, "this":La/b/c/f/j$d;, "Landroid/support/v4/util/MapCollections<TK;TV;>.MapIterator;"
    .local p1, "object":Ljava/lang/Object;, "TV;"
    iget-boolean v0, p0, La/b/c/f/j$d;->c:Z

    if-eqz v0, :cond_0

    .line 132
    iget-object v0, p0, La/b/c/f/j$d;->d:La/b/c/f/j;

    iget v1, p0, La/b/c/f/j$d;->b:I

    invoke-virtual {v0, v1, p1}, La/b/c/f/j;->a(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    .line 129
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "This container does not support retaining Map.Entry objects"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .line 163
    .local p0, "this":La/b/c/f/j$d;, "Landroid/support/v4/util/MapCollections<TK;TV;>.MapIterator;"
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, La/b/c/f/j$d;->getKey()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, La/b/c/f/j$d;->getValue()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
