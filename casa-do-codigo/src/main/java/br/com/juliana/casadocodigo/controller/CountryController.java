package br.com.juliana.casadocodigo.controller;

@RestController
    @RequestMapping("/countries")
    public class CountryController {

        @Autowired
        private CountryRepository countryRepository;

        @PostMapping
        @Transactional
        public ResponseEntity<CountryDTO> save(@RequestBody @Valid NewCountryRequest req, UriComponentsBuilder uriBuilder) {
            var country = countryRepository.save(req.toModel());
            URI uri = uriBuilder.path("/countries/{id}").buildAndExpand(country.getId()).toUri();
            return ResponseEntity.created(uri).body(new CountryDTO(country));
        }

        @GetMapping
        public Page<CountryDTO> list(@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pagination) {
            return countryRepository.findAll(pagination).map(CountryDTO::new);
        }

    }