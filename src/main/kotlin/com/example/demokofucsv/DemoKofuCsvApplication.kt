package com.example.demokofucsv

import com.example.democsvartemis.service.CsvArtemisService
import com.example.democsvartemis.service.impl.CsvArtemisServiceImpl
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.WebApplicationType
import org.springframework.fu.kofu.application

val app = application(WebApplicationType.NONE) {
    beans {
        bean<CsvArtemisServiceImpl>()

        bean {
            CommandLineRunner {
                val csvProperties = ref<CsvProperties>()
                val csvArtemisService = ref<CsvArtemisService>()
                csvArtemisService.procesarFichero(csvProperties.dir)
            }
        }
    }

    configurationProperties<CsvProperties>(prefix = "csv")
}

class CsvProperties(val dir: String)

fun main() {
    app.run()
}
