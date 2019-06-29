.class Landroid/support/v4/app/N;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v4/app/P;->a(Landroid/view/View;Ljava/util/ArrayList;Ljava/util/Map;)V
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

    .line 233
    iput-object p1, p0, Landroid/support/v4/app/N;->c:Landroid/support/v4/app/P;

    iput-object p2, p0, Landroid/support/v4/app/N;->a:Ljava/util/ArrayList;

    iput-object p3, p0, Landroid/support/v4/app/N;->b:Ljava/util/Map;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .line 236
    iget-object v0, p0, Landroid/support/v4/app/N;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 237
    .local v0, "numSharedElements":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_1

    .line 238
    iget-object v2, p0, Landroid/support/v4/app/N;->a:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/View;

    .line 239
    .local v2, "view":Landroid/view/View;
    invoke-static {v2}, La/b/c/g/u;->f(Landroid/view/View;)Ljava/lang/String;

    move-result-object v3

    .line 240
    .local v3, "name":Ljava/lang/String;
    if-eqz v3, :cond_0

    .line 241
    iget-object v4, p0, Landroid/support/v4/app/N;->b:Ljava/util/Map;

    invoke-static {v4, v3}, Landroid/support/v4/app/P;->a(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 242
    .local v4, "inName":Ljava/lang/String;
    invoke-static {v2, v4}, La/b/c/g/u;->a(Landroid/view/View;Ljava/lang/String;)V

    .line 237
    .end local v2    # "view":Landroid/view/View;
    .end local v3    # "name":Ljava/lang/String;
    .end local v4    # "inName":Ljava/lang/String;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 245
    .end local v1    # "i":I
    :cond_1
    return-void
.end method
