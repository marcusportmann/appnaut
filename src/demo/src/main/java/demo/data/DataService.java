/*
 * Copyright 2021 Marcus Portmann
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package demo.data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import javax.inject.Singleton;
import javax.transaction.Transactional;

/**
 * The <b>DataService</b> class.
 *
 * @author Marcus Portmann
 */
@Singleton
public class DataService implements IDataService {

  private final DataRepository dataRepository;

  public DataService(DataRepository dataRepository) {
    this.dataRepository = dataRepository;
  }

  /**
   * Create a new data.
   *
   * @param data the data
   *
   * @return the data that was created
   */
  @Transactional
  @Override
  public void createData(Data data) {
    dataRepository.save(data);
  }

  /**
   * Retrieve all the data.
   *
   * @return all the data
   */
  @Override
  public List<Data> getAllData() {
    return StreamSupport.stream(dataRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

}
