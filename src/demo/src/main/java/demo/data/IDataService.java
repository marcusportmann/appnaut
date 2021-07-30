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

/**
 * The <b>IDataService</b> interface.
 *
 * @author Marcus Portmann
 */
public interface IDataService {

  /**
   * Create a new data.
   *
   * @param data the data
   *
   * @return the data that was created
   */
  void createData(Data data);

  /**
   * Retrieve the data.
   *
   * @return the data
   */
  List<Data> getAllData();
}
