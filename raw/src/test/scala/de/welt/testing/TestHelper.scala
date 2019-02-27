package de.welt.testing

import de.welt.contentapi.raw.models._

object TestHelper {

  object raw {

    object channel {
      def emptyWithId(id: Long) =
        RawChannel(RawChannelId(path = s"/$id/", escenicId = id, label = id.toString))

      def emptyWithIdAndConfig(id: Long, config: RawChannelConfiguration) =
        RawChannel(RawChannelId(path = s"/$id/", escenicId = id, label = id.toString), config = config)

      def emptyWithIdAndStageConfig(id: Long, config: RawChannelStageConfiguration) =
        RawChannel(RawChannelId(path = s"/$id/", escenicId = id, label = id.toString), stageConfiguration = Some(config))

      def emptyWithIdAndMetadata(id: Long, metadata: RawMetadata) =
        RawChannel(RawChannelId(path = s"/$id/", escenicId = id, label = id.toString), metadata = metadata)

      def emptyWithIdAndChildren(id: Long, children: Seq[RawChannel]) =
        RawChannel(RawChannelId(path = s"/$id/", escenicId = id, label = id.toString), children = children)

      def emptyWithIdAndChildrenAndConfig(id: Long, children: Seq[RawChannel], config: RawChannelConfiguration) =
        RawChannel(RawChannelId(path = s"/$id/", escenicId = id, label = id.toString), children = children, config = config)

      def emptyWithIdAndChildrenAndMetadata(id: Long, children: Seq[RawChannel], metadata: RawMetadata) =
        RawChannel(RawChannelId(path = s"/$id/", escenicId = id, label = id.toString), children = children, metadata = metadata)
    }

    object metadata {
      def withChangedBy(changedBy: String) = RawMetadata(
        changedBy = changedBy
      )
    }

    object configuration {

      def withTitleAndAds(title: String, adsEnabled: Boolean) = RawChannelConfiguration(
        metadata = Some(RawChannelMetadata(title = Some(title))),
        commercial = RawChannelCommercial(definesAdTag = adsEnabled, definesVideoAdTag = adsEnabled)
      )

      def withAds(adsEnabled: Boolean) = RawChannelConfiguration(
        commercial = RawChannelCommercial(definesAdTag = adsEnabled, definesVideoAdTag = adsEnabled)
      )

      def withBrand(brand: Boolean) = RawChannelConfiguration(
        brand = brand
      )

      def withMaster(master: Boolean) = RawChannelConfiguration(
        master = master
      )

      def withTheme(name: String) = RawChannelConfiguration(
        theme = Some(RawChannelTheme(name = Some(name)))
      )
    }

    object stageConfiguration {
      def withStage(stage: RawChannelStage) = RawChannelStageConfiguration(
        stages = Some(Seq(stage))
      )
    }
  }

}
