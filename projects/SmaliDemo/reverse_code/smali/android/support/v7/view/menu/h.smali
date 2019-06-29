.class Landroid/support/v7/view/menu/h;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/support/v7/widget/V;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/view/menu/i;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/view/menu/i;


# direct methods
.method constructor <init>(Landroid/support/v7/view/menu/i;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/view/menu/i;

    .line 137
    iput-object p1, p0, Landroid/support/v7/view/menu/h;->a:Landroid/support/v7/view/menu/i;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/support/v7/view/menu/l;Landroid/view/MenuItem;)V
    .locals 8
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;
    .param p2, "item"    # Landroid/view/MenuItem;

    .line 150
    iget-object v0, p0, Landroid/support/v7/view/menu/h;->a:Landroid/support/v7/view/menu/i;

    iget-object v0, v0, Landroid/support/v7/view/menu/i;->h:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 153
    const/4 v0, -0x1

    .line 154
    .local v0, "menuIndex":I
    const/4 v1, 0x0

    .local v1, "i":I
    iget-object v2, p0, Landroid/support/v7/view/menu/h;->a:Landroid/support/v7/view/menu/i;

    iget-object v2, v2, Landroid/support/v7/view/menu/i;->j:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    .local v2, "count":I
    :goto_0
    if-ge v1, v2, :cond_1

    .line 155
    iget-object v3, p0, Landroid/support/v7/view/menu/h;->a:Landroid/support/v7/view/menu/i;

    iget-object v3, v3, Landroid/support/v7/view/menu/i;->j:Ljava/util/List;

    invoke-interface {v3, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/support/v7/view/menu/i$a;

    iget-object v3, v3, Landroid/support/v7/view/menu/i$a;->b:Landroid/support/v7/view/menu/l;

    if-ne p1, v3, :cond_0

    .line 156
    move v0, v1

    .line 157
    goto :goto_1

    .line 154
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 161
    .end local v1    # "i":I
    .end local v2    # "count":I
    :cond_1
    :goto_1
    const/4 v1, -0x1

    if-ne v0, v1, :cond_2

    .line 162
    return-void

    .line 166
    :cond_2
    add-int/lit8 v1, v0, 0x1

    .line 167
    .local v1, "nextIndex":I
    iget-object v2, p0, Landroid/support/v7/view/menu/h;->a:Landroid/support/v7/view/menu/i;

    iget-object v2, v2, Landroid/support/v7/view/menu/i;->j:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_3

    .line 168
    iget-object v2, p0, Landroid/support/v7/view/menu/h;->a:Landroid/support/v7/view/menu/i;

    iget-object v2, v2, Landroid/support/v7/view/menu/i;->j:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v7/view/menu/i$a;

    .local v2, "nextInfo":Landroid/support/v7/view/menu/i$a;
    goto :goto_2

    .line 170
    .end local v2    # "nextInfo":Landroid/support/v7/view/menu/i$a;
    :cond_3
    const/4 v2, 0x0

    .line 173
    .restart local v2    # "nextInfo":Landroid/support/v7/view/menu/i$a;
    :goto_2
    new-instance v3, Landroid/support/v7/view/menu/g;

    invoke-direct {v3, p0, v2, p2, p1}, Landroid/support/v7/view/menu/g;-><init>(Landroid/support/v7/view/menu/h;Landroid/support/v7/view/menu/i$a;Landroid/view/MenuItem;Landroid/support/v7/view/menu/l;)V

    .line 192
    .local v3, "runnable":Ljava/lang/Runnable;
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v4

    const-wide/16 v6, 0xc8

    add-long/2addr v4, v6

    .line 193
    .local v4, "uptimeMillis":J
    iget-object v6, p0, Landroid/support/v7/view/menu/h;->a:Landroid/support/v7/view/menu/i;

    iget-object v6, v6, Landroid/support/v7/view/menu/i;->h:Landroid/os/Handler;

    invoke-virtual {v6, v3, p1, v4, v5}, Landroid/os/Handler;->postAtTime(Ljava/lang/Runnable;Ljava/lang/Object;J)Z

    .line 194
    return-void
.end method

.method public b(Landroid/support/v7/view/menu/l;Landroid/view/MenuItem;)V
    .locals 1
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;
    .param p2, "item"    # Landroid/view/MenuItem;

    .line 143
    iget-object v0, p0, Landroid/support/v7/view/menu/h;->a:Landroid/support/v7/view/menu/i;

    iget-object v0, v0, Landroid/support/v7/view/menu/i;->h:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 144
    return-void
.end method
