.class Landroid/support/v4/app/O;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v4/app/P;->a(Landroid/view/ViewGroup;Ljava/util/ArrayList;Ljava/util/Map;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Ljava/util/ArrayList;

.field final synthetic b:Ljava/util/Map;

.field final synthetic c:Landroid/support/v4/app/P;


# direct methods
.method constructor <init>(Landroid/support/v4/app/P;Ljava/util/ArrayList;Ljava/util/Map;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v4/app/P;

    .line 292
    iput-object p1, p0, Landroid/support/v4/app/O;->c:Landroid/support/v4/app/P;

    iput-object p2, p0, Landroid/support/v4/app/O;->a:Ljava/util/ArrayList;

    iput-object p3, p0, Landroid/support/v4/app/O;->b:Ljava/util/Map;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .line 295
    iget-object v0, p0, Landroid/support/v4/app/O;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 296
    .local v0, "numSharedElements":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 297
    iget-object v2, p0, Landroid/support/v4/app/O;->a:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/View;

    .line 298
    .local v2, "view":Landroid/view/View;
    invoke-static {v2}, La/b/c/g/u;->f(Landroid/view/View;)Ljava/lang/String;

    move-result-object v3

    .line 299
    .local v3, "name":Ljava/lang/String;
    iget-object v4, p0, Landroid/support/v4/app/O;->b:Ljava/util/Map;

    invoke-interface {v4, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 300
    .local v4, "inName":Ljava/lang/String;
    invoke-static {v2, v4}, La/b/c/g/u;->a(Landroid/view/View;Ljava/lang/String;)V

    .line 296
    .end local v2    # "view":Landroid/view/View;
    .end local v3    # "name":Ljava/lang/String;
    .end local v4    # "inName":Ljava/lang/String;
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 302
    .end local v1    # "i":I
    :cond_0
    return-void
.end method
