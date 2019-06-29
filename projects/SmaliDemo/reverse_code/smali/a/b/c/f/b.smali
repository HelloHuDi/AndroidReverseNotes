.class public La/b/c/f/b;
.super La/b/c/f/m;
.source ""

# interfaces
.implements Ljava/util/Map;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "La/b/c/f/m<",
        "TK;TV;>;",
        "Ljava/util/Map<",
        "TK;TV;>;"
    }
.end annotation


# instance fields
.field h:La/b/c/f/j;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "La/b/c/f/j<",
            "TK;TV;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 57
    .local p0, "this":La/b/c/f/b;, "Landroid/support/v4/util/ArrayMap<TK;TV;>;"
    invoke-direct {p0}, La/b/c/f/m;-><init>()V

    .line 58
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "capacity"    # I

    .line 64
    .local p0, "this":La/b/c/f/b;, "Landroid/support/v4/util/ArrayMap<TK;TV;>;"
    invoke-direct {p0, p1}, La/b/c/f/m;-><init>(I)V

    .line 65
    return-void
.end method

.method private b()La/b/c/f/j;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "La/b/c/f/j<",
            "TK;TV;>;"
        }
    .end annotation

    .line 75
    .local p0, "this":La/b/c/f/b;, "Landroid/support/v4/util/ArrayMap<TK;TV;>;"
    iget-object v0, p0, La/b/c/f/b;->h:La/b/c/f/j;

    if-nez v0, :cond_0

    .line 76
    new-instance v0, La/b/c/f/a;

    invoke-direct {v0, p0}, La/b/c/f/a;-><init>(La/b/c/f/b;)V

    iput-object v0, p0, La/b/c/f/b;->h:La/b/c/f/j;

    .line 123
    :cond_0
    iget-object v0, p0, La/b/c/f/b;->h:La/b/c/f/j;

    return-object v0
.end method


# virtual methods
.method public a(Ljava/util/Collection;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "*>;)Z"
        }
    .end annotation

    .line 164
    .local p0, "this":La/b/c/f/b;, "Landroid/support/v4/util/ArrayMap<TK;TV;>;"
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<*>;"
    invoke-static {p0, p1}, La/b/c/f/j;->c(Ljava/util/Map;Ljava/util/Collection;)Z

    move-result v0

    return v0
.end method

.method public entrySet()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set<",
            "Ljava/util/Map$Entry<",
            "TK;TV;>;>;"
        }
    .end annotation

    .line 182
    .local p0, "this":La/b/c/f/b;, "Landroid/support/v4/util/ArrayMap<TK;TV;>;"
    invoke-direct {p0}, La/b/c/f/b;->b()La/b/c/f/j;

    move-result-object v0

    invoke-virtual {v0}, La/b/c/f/j;->d()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public keySet()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set<",
            "TK;>;"
        }
    .end annotation

    .line 194
    .local p0, "this":La/b/c/f/b;, "Landroid/support/v4/util/ArrayMap<TK;TV;>;"
    invoke-direct {p0}, La/b/c/f/b;->b()La/b/c/f/j;

    move-result-object v0

    invoke-virtual {v0}, La/b/c/f/j;->e()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public putAll(Ljava/util/Map;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map<",
            "+TK;+TV;>;)V"
        }
    .end annotation

    .line 142
    .local p0, "this":La/b/c/f/b;, "Landroid/support/v4/util/ArrayMap<TK;TV;>;"
    .local p1, "map":Ljava/util/Map;, "Ljava/util/Map<+TK;+TV;>;"
    iget v0, p0, La/b/c/f/m;->g:I

    invoke-interface {p1}, Ljava/util/Map;->size()I

    move-result v1

    add-int/2addr v0, v1

    invoke-virtual {p0, v0}, La/b/c/f/m;->a(I)V

    .line 143
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 144
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<+TK;+TV;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {p0, v2, v3}, La/b/c/f/m;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 145
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<+TK;+TV;>;"
    goto :goto_0

    .line 146
    :cond_0
    return-void
.end method

.method public values()Ljava/util/Collection;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection<",
            "TV;>;"
        }
    .end annotation

    .line 206
    .local p0, "this":La/b/c/f/b;, "Landroid/support/v4/util/ArrayMap<TK;TV;>;"
    invoke-direct {p0}, La/b/c/f/b;->b()La/b/c/f/j;

    move-result-object v0

    invoke-virtual {v0}, La/b/c/f/j;->f()Ljava/util/Collection;

    move-result-object v0

    return-object v0
.end method
