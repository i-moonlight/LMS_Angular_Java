import { NgModule } from "@angular/core";
import { BrowserModule, Title } from "@angular/platform-browser";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { AuthModule } from "./auth/auth.module";
import { AboutHeaderComponent } from "./components/about/about-header/about-header.component";
import { AboutNavigationComponent } from "./components/about/about-navigation/about-navigation.component";
import { AboutComponent } from "./components/about/about.component";
import { DefaultEventListComponent } from "./components/index/events/default-event-list/default-event-list.component";
import { DefaultEventComponent } from "./components/index/events/default-event/default-event.component";
import { EventDateComponent } from "./components/index/events/event-date/event-date.component";
import { EventInfoComponent } from "./components/index/events/event-info/event-info.component";
import { EventsComponent } from "./components/index/events/events.component";
import { FeaturedEventComponent } from "./components/index/events/featured-event/featured-event.component";
import { FindOutMoreCardComponent } from "./components/index/find-out-more-card/find-out-more-card.component";
import { FindOutMoreComponent } from "./components/index/find-out-more/find-out-more.component";
import { HeaderComponent } from "./components/index/header/header.component";
import { IndexComponent } from "./components/index/index.component";
import { NewsCardComponent } from "./components/index/news-card/news-card.component";
import { NewsComponent } from "./components/index/news/news.component";
import { SharedModule } from "./shared/shared.module";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AboutComponent,
    NewsComponent,
    NewsCardComponent,
    FindOutMoreComponent,
    IndexComponent,
    FindOutMoreCardComponent,
    EventsComponent,
    EventDateComponent,
    FeaturedEventComponent,
    EventInfoComponent,
    DefaultEventComponent,
    DefaultEventListComponent,
    AboutHeaderComponent,
    AboutNavigationComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, SharedModule, AuthModule],
  providers: [Title],
  bootstrap: [AppComponent],
})
export class AppModule {}
