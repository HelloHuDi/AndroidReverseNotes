.class final La/b/c/f/j$c;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/util/Set;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/b/c/f/j;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "c"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Set<",
        "TK;>;"
    }
.end annotation


# instance fields
.field final synthetic a:La/b/c/f/j;


# direct methods
.method constructor <init>(La/b/c/f/j;)V
    .locals 0
    .param p1, "this$0"    # La/b/c/f/j;

    .line 269
    .local p0, "this":La/b/c/f/j$c;, "Landroid/support/v4/util/MapCollections<TK;TV;>.KeySet;"
    iput-object p1, p0, La/b/c/f/j$c;->a:La/b/c/f/j;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public add(Ljava/lang/Object;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;)Z"
        }
    .end annotation

    .line 273
    .local p0, "this":La/b/c/f/j$c;, "Landroid/support/v4/util/MapCollections<TK;TV;>.KeySet;"
    .local p1, "object":Ljava/lang/Object;, "TK;"
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public addAll(Ljava/util/Collection;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "+TK;>;)Z"
        }
    .end annotation

    .line 278
    .local p0, "this":La/b/c/f/j$c;, "Landroid/support/v4/util/MapCollections<TK;TV;>.KeySet;"
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<+TK;>;"
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public clear()V
    .locals 1

    .line 283
    .local p0, "this":La/b/c/f/j$c;, "Landroid/support/v4/util/MapCollections<TK;TV;>.KeySet;"
    iget-object v0, p0, La/b/c/f/j$c;->a:La/b/c/f/j;

    invoke-virtual {v0}, La/b/c/f/j;->a()V

    .line 284
    return-void
.end method

.method public contains(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "object"    # Ljava/lang/Object;

    .line 288
    .local p0, "this":La/b/c/f/j$c;, "Landroid/support/v4/util/MapCollections<TK;TV;>.KeySet;"
    iget-object v0, p0, La/b/c/f/j$c;->a:La/b/c/f/j;

    invoke-virtual {v0, p1}, La/b/c/f/j;->a(Ljava/lang/Object;)I

    move-result v0

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public containsAll(Ljava/util/Collection;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "*>;)Z"
        }
    .end annotation

    .line 293
    .local p0, "this":La/b/c/f/j$c;, "Landroid/support/v4/util/MapCollections<TK;TV;>.KeySet;"
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<*>;"
    iget-object v0, p0, La/b/c/f/j$c;->a:La/b/c/f/j;

    invoke-virtual {v0}, La/b/c/f/j;->b()Ljava/util/Map;

    move-result-object v0

    invoke-static {v0, p1}, La/b/c/f/j;->a(Ljava/util/Map;Ljava/util/Collection;)Z

    move-result v0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "object"    # Ljava/lang/Object;

    .line 343
    .local p0, "this":La/b/c/f/j$c;, "Landroid/support/v4/util/MapCollections<TK;TV;>.KeySet;"
    invoke-static {p0, p1}, La/b/c/f/j;->a(Ljava/util/Set;Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public hashCode()I
    .locals 4

    .line 348
    .local p0, "this":La/b/c/f/j$c;, "Landroid/support/v4/util/MapCollections<TK;TV;>.KeySet;"
    const/4 v0, 0x0

    .line 349
    .local v0, "result":I
    iget-object v1, p0, La/b/c/f/j$c;->a:La/b/c/f/j;

    invoke-virtual {v1}, La/b/c/f/j;->c()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    .local v1, "i":I
    :goto_0
    if-ltz v1, :cond_1

    .line 350
    iget-object v2, p0, La/b/c/f/j$c;->a:La/b/c/f/j;

    const/4 v3, 0x0

    invoke-virtual {v2, v1, v3}, La/b/c/f/j;->a(II)Ljava/lang/Object;

    move-result-object v2

    .line 351
    .local v2, "obj":Ljava/lang/Object;
    if-nez v2, :cond_0

    goto :goto_1

    :cond_0
    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v3

    :goto_1
    add-int/2addr v0, v3

    .line 349
    .end local v2    # "obj":Ljava/lang/Object;
    add-int/lit8 v1, v1, -0x1

    goto :goto_0

    .line 353
    .end local v1    # "i":I
    :cond_1
    return v0
.end method

.method public isEmpty()Z
    .locals 1

    .line 298
    .local p0, "this":La/b/c/f/j$c;, "Landroid/support/v4/util/MapCollections<TK;TV;>.KeySet;"
    iget-object v0, p0, La/b/c/f/j$c;->a:La/b/c/f/j;

    invoke-virtual {v0}, La/b/c/f/j;->c()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public iterator()Ljava/util/Iterator;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator<",
            "TK;>;"
        }
    .end annotation

    .line 303
    .local p0, "this":La/b/c/f/j$c;, "Landroid/support/v4/util/MapCollections<TK;TV;>.KeySet;"
    new-instance v0, La/b/c/f/j$a;

    iget-object v1, p0, La/b/c/f/j$c;->a:La/b/c/f/j;

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, La/b/c/f/j$a;-><init>(La/b/c/f/j;I)V

    return-object v0
.end method

.method public remove(Ljava/lang/Object;)Z
    .locals 2
    .param p1, "object"    # Ljava/lang/Object;

    .line 308
    .local p0, "this":La/b/c/f/j$c;, "Landroid/support/v4/util/MapCollections<TK;TV;>.KeySet;"
    iget-object v0, p0, La/b/c/f/j$c;->a:La/b/c/f/j;

    invoke-virtual {v0, p1}, La/b/c/f/j;->a(Ljava/lang/Object;)I

    move-result v0

    .line 309
    .local v0, "index":I
    if-ltz v0, :cond_0

    .line 310
    iget-object v1, p0, La/b/c/f/j$c;->a:La/b/c/f/j;

    invoke-virtual {v1, v0}, La/b/c/f/j;->a(I)V

    .line 311
    const/4 v1, 0x1

    return v1

    .line 313
    :cond_0
    const/4 v1, 0x0

    return v1
.end method

.method public removeAll(Ljava/util/Collection;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "*>;)Z"
        }
    .end annotation

    .line 318
    .local p0, "this":La/b/c/f/j$c;, "Landroid/support/v4/util/MapCollections<TK;TV;>.KeySet;"
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<*>;"
    iget-object v0, p0, La/b/c/f/j$c;->a:La/b/c/f/j;

    invoke-virtual {v0}, La/b/c/f/j;->b()Ljava/util/Map;

    move-result-object v0

    invoke-static {v0, p1}, La/b/c/f/j;->b(Ljava/util/Map;Ljava/util/Collection;)Z

    move-result v0

    return v0
.end method

.method public retainAll(Ljava/util/Collection;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "*>;)Z"
        }
    .end annotation

    .line 323
    .local p0, "this":La/b/c/f/j$c;, "Landroid/support/v4/util/MapCollections<TK;TV;>.KeySet;"
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<*>;"
    iget-object v0, p0, La/b/c/f/j$c;->a:La/b/c/f/j;

    invoke-virtual {v0}, La/b/c/f/j;->b()Ljava/util/Map;

    move-result-object v0

    invoke-static {v0, p1}, La/b/c/f/j;->c(Ljava/util/Map;Ljava/util/Collection;)Z

    move-result v0

    return v0
.end method

.method public size()I
    .locals 1

    .line 328
    .local p0, "this":La/b/c/f/j$c;, "Landroid/support/v4/util/MapCollections<TK;TV;>.KeySet;"
    iget-object v0, p0, La/b/c/f/j$c;->a:La/b/c/f/j;

    invoke-virtual {v0}, La/b/c/f/j;->c()I

    move-result v0

    return v0
.end method

.method public toArray()[Ljava/lang/Object;
    .locals 2

    .line 333
    .local p0, "this":La/b/c/f/j$c;, "Landroid/support/v4/util/MapCollections<TK;TV;>.KeySet;"
    iget-object v0, p0, La/b/c/f/j$c;->a:La/b/c/f/j;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, La/b/c/f/j;->b(I)[Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public toArray([Ljava/lang/Object;)[Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">([TT;)[TT;"
        }
    .end annotation

    .line 338
    .local p0, "this":La/b/c/f/j$c;, "Landroid/support/v4/util/MapCollections<TK;TV;>.KeySet;"
    .local p1, "array":[Ljava/lang/Object;, "[TT;"
    iget-object v0, p0, La/b/c/f/j$c;->a:La/b/c/f/j;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, La/b/c/f/j;->a([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method
