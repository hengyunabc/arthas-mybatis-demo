/**
 *    Copyright 2015-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package sample.mybatis;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import sample.mybatis.dao.CityDao;
import sample.mybatis.mapper.HotelMapper;

@EnableScheduling
@SpringBootApplication
public class SampleXmlApplication {

  public static void main(String[] args) {
    SpringApplication.run(SampleXmlApplication.class, args);
    
  }

  private final CityDao cityDao;

  private final HotelMapper hotelMapper;

  public SampleXmlApplication(CityDao cityDao, HotelMapper hotelMapper) {
    this.cityDao = cityDao;
    this.hotelMapper = hotelMapper;
  }
  
  @Scheduled(initialDelay = 1000, fixedRate = 5000)
  public void sample() {
      //System.out.println(this.cityDao.selectCityById(1));
      System.out.println(this.hotelMapper.selectByCityId(1));
  }

}
